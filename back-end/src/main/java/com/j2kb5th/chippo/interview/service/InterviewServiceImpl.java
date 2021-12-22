package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.controller.dto.request.*;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.tag.domain.InterviewTag;
import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.tag.repository.InterviewTagRepository;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;
    private final InterviewTagRepository interviewTagRepository;

    private User findUserById(Long userId) {
        // 유저 정보 불러오기
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.GL001));
        return user;
    }

    private void validateUserAuthority(User user, Long requestUserId) {
        // 유저 권한 체크
        // Role 체크, 활성화 유저, requestUserId와의 일치여부 등
        if (! user.hasAuthority(requestUserId)) {
            throw new GlobalException(HttpStatus.FORBIDDEN, ErrorMessage.GL004);
        }
    }

    private Tag findTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.TA005));
    }

    private Tag findTagByNameAndType(String tagName, TagType tagType) {
        return tagRepository.findByNameAndType(tagName, tagType)
                .orElseThrow(() -> new GlobalException(HttpStatus.NO_CONTENT, ErrorMessage.TA004));
    }

    private Tag findOrSaveTagByNameAndType(InterviewTagDetailRequest tagRequest) {
        return tagRepository.findByNameAndType(tagRequest.getName(), tagRequest.getType())
                .orElse(tagRepository.save(tagRequest.toEntity()));
    }

    private void saveInterviewTags(Interview interview, List<Tag> tags) {
        for (Tag tag: tags) {
            InterviewTag interviewTag = InterviewTag.builder()
                    .interview(interview)
                    .tag(tag)
                    .build();

            // 기술면접태그 저장
            interviewTagRepository.save(interviewTag);

            // 기술면접 -> 기술면접태그 추가
            interview.addInterviewTag(interviewTag);

            // 태그 -> 기술면접태그 추가
            tag.addInterviewTag(interviewTag);
        }
    }


    /**
     * 태그타입별 tag request 리스트 추출
     * @param interviewRequest: save/update interviewRequest
     * @return TagType을 key, 해당 태그타입에 속하는 tag request list를 value로 갖는 map 객체 리턴
     */
    private Map<TagType, List<InterviewTagDetailRequest>> extractTagTypeListMap(InterviewRequest interviewRequest) {
        Map<TagType, List<InterviewTagDetailRequest>> tagTypeListMap = Optional.ofNullable(interviewRequest.getInterviewTags())
                .orElseThrow(() -> new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA003)) // 전체 미작성 시 에러
                .stream()
                .collect(Collectors.groupingBy(InterviewTagDetailRequest::getType));
        return tagTypeListMap;
    }

    /**
     * 기술스택 미작성 여부 검사
     * @param tagTypeListMap: TagType을 key로 매핑된 태그 request의 map
     */
    private void validateTechStackTags(Map<TagType, List<InterviewTagDetailRequest>> tagTypeListMap) {
        int techStackCount = tagTypeListMap.getOrDefault(TagType.TECHSTACK, new ArrayList<>()).size();
        if (techStackCount == 0) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA001);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Interview findInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.IN001));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Interview> findInterviewsByTag(String tagName, TagType tagType, Long size) {
        // 처리 순서
        // 태그 정보(name, type) -> 태그 객체 찾기
        Tag tag = findTagByNameAndType(tagName, tagType);

        // 태그 객체(태그 id) -> 인터뷰태그 객체 찾기
        List<InterviewTag> interviewTags = tag.getInterviewTags();

        // 인터뷰태그 객체(의 인터뷰 id) -> 인터뷰 객체 찾기
        List<Interview> interviews = interviewTags.stream()
                .map(interviewTag -> findInterviewById(interviewTag.getInterview().getId()))
                .collect(Collectors.toList());

        // size만큼 슬라이싱
        return interviews.subList(0, (interviews.size() > size) ? size.intValue() : interviews.size());
    }

    /**
     * 기술면접 등록
     * @param interviewRequest: 기술면접 등록 request dto
     * @param userId: 기술면접 작성자 id
     * @return 등록 완료된 기술면접
     */
    @Override
    @Transactional
    public Interview saveInterview(SaveInterviewRequest interviewRequest, Long userId) {
        /////// 유저
        // 조회
        User user = findUserById(userId);

        // 권한 체크
        validateUserAuthority(user, interviewRequest.getUserId());

        /////// 태그
        // 태그타입별로 태그 request dto 리스트 추출
        Map<TagType, List<InterviewTagDetailRequest>> tagTypeListMap = extractTagTypeListMap(interviewRequest);

        // 기술스택 미작성 시 에러
        validateTechStackTags(tagTypeListMap);

        List<Tag> tags = new ArrayList<>();

        for (List<InterviewTagDetailRequest> tagList: tagTypeListMap.values()){
            // 태그 타입별 개수 초과 작성 시 에러
            if (tagList.size() > 3) {
                throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA002);
            }

            // 중복 검사하여 없을 경우 저장
            for (InterviewTagDetailRequest tagRequest: tagList) {
                Tag tag = findOrSaveTagByNameAndType((SaveInterviewTagDetailRequest) tagRequest);
                tags.add(tag);
            }
        }

        /////// 기술면접 저장
        Interview interview = interviewRepository.save(interviewRequest.toEntity(user));

        for (Tag tag: tags) {
            InterviewTag interviewTag = InterviewTag.builder()
                    .interview(interview)
                    .tag(tag)
                    .build();

            ////// 기술면접태그 저장
            interviewTagRepository.save(interviewTag);

            ////// 기술면접 -> 기술면접태그 추가
            interview.addInterviewTag(interviewTag);

            ///// 태그 -> 기술면접태그 추가
            tag.addInterviewTag(interviewTag);
        }

        return interview;
    }

    /**
     * 기술면접 수정
     * @param interviewRequest: 기술면접 수정 request dto
     * @param userId: 기술면접 작성자 id
     * @return 수정된 기술면접
     */
    @Override
    @Transactional
    public Interview updateInterview(UpdateInterviewRequest interviewRequest, Long userId) {
        /////// 유저
        // 조회
        User user = findUserById(userId);

        // 권한 체크
        validateUserAuthority(user, interviewRequest.getUserId());

        /////// 태그
        // 태그타입별로 태그 request dto 리스트 추출
        Map<TagType, List<InterviewTagDetailRequest>> tagTypeListMap = extractTagTypeListMap(interviewRequest);

        // 기술스택 미작성 시 에러
        validateTechStackTags(tagTypeListMap);

        List<Tag> tags = new ArrayList<>();

        for (List<InterviewTagDetailRequest> tagList: tagTypeListMap.values()){
            // 태그 타입별 개수 초과 작성 시 에러
            if (tagList.size() > 3) {
                throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA002);
            }

            // 중복 검사하여 없을 경우 저장
            for (InterviewTagDetailRequest tagRequest: tagList) {
                if (((UpdateInterviewTagDetailRequest) tagRequest).getId() == null) { // 사용자가 새로 등록한 태그
                    Tag tag = findOrSaveTagByNameAndType(tagRequest);
                    tags.add(tag);
                } // 이미 등록한 태그는 등록 필요 없음
            }
        }

        /////// 기술면접 불러오기
        Interview interview = findInterviewById(interviewRequest.getId());

        // 기술면접 업데이트
        interview.updateQuestion(interviewRequest.getQuestion());
        interview.updateAnswer(interviewRequest.getAnswer());
        interview.updateExtraInfo(interviewRequest.getExtraInfo());

        ////// 기술면접태그 추가
        saveInterviewTags(interview, tags);

        return interview;
    }

    @Override
    @Transactional
    public void deleteInterview(Long interviewId, Long userId) {

    }
}
