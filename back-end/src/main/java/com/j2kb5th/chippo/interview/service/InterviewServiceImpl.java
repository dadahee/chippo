package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewRequest;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.tag.domain.InterviewTag;
import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    private final TagRepository tagRepository;

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
        List<Tag> tags = tagRepository.findByNameAndType(tagName, tagType);


        // 태그 객체(태그 id) -> 인터뷰태그 객체 찾기
        List<InterviewTag> interviewTags = tags.stream()
                .map(tag -> tag.getInterviewTags())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 인터뷰태그 객체(의 인터뷰 id) -> 인터뷰 객체 찾기
        List<Interview> interviews = interviewTags.stream()
                .map(interviewTag -> findInterviewById(interviewTag.getInterview().getId()))
                .distinct() // 중복 방지
                .collect(Collectors.toList());
        return interviews;
    }

    @Override
    @Transactional
    public Interview saveInterview(SaveInterviewRequest interviewRequest, Long userId) {
        ///// 태그
        // 기술스택 미작성 시 에러
        Long techStackCount = interviewRequest.getInterviewTags().stream()
                .filter(interviewTag -> interviewTag.getType().equals(TagType.TECHSTACK))
                .count();
        if (techStackCount == 0) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA001);
        } else if (techStackCount > 3) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, ErrorMessage.TA002);
        }
        return null;
    }
}
