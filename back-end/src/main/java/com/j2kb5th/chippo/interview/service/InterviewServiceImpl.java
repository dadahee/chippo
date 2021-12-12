package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.tag.domain.InterviewTag;
import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.tag.repository.InterviewTagRepository;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    private final TagRepository tagRepository;
    private final InterviewTagRepository interviewTagRepository;

    @Override
    public Interview findInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.IN001));
    }

    @Override
    public List<Interview> findInterviewsByTag(String tagName, TagType tagType, Long size) {
        // 처리 순서
        // 태그 정보(name, type) -> 태그 객체 찾기
        List<Tag> tags = tagRepository.findByNameAndType(tagName, tagType);

        // 태그 객체(태그 id) -> 인터뷰태그 객체 찾기
        // 중복 방지를 위해 Set 타입 사용
        Set<InterviewTag> interviewTags = tags.stream()
                .map(tag -> interviewTagRepository.findByTagId(tag.getId()))
                .flatMap(s -> s.stream())
                .collect(Collectors.toSet());

        // 인터뷰태그 객체(의 인터뷰 id) -> 인터뷰 객체 찾기
        List<Interview> interviews = interviewTags.stream()
                .map(interviewTag -> interviewRepository.findById(interviewTag.getInterview().getId())
                        .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.GL002)))
                .collect(Collectors.toList());

        return interviews;
    }
}
