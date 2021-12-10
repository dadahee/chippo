package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
    private final TagRepository tagRepository;

    @Override
    public Interview findInterviewById(Long interviewId) {
        return interviewRepository.findById(interviewId)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.IN001));
    }

    @Override
    public List<Interview> findInterviewsByTag(String tagName, TagType tagType, Long size) {
        // 처리 순서
        // 태그 정보(name, type) -> 태그 객체 찾기
        // 태그 객체(태그 id) -> 인터뷰태그 객체 찾기
        // 인터뷰태그 객체(의 인터뷰 id) -> 인터뷰 객체 찾기
        // 이게 뭔데.... 어떻게 하는 건데...
        return null;
    }
}
