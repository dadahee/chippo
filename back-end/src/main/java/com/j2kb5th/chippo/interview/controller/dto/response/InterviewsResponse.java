package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.interview.domain.Interview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 구현 후 삭제
public class InterviewsResponse {
    private final List<InterviewResponse> interviews;

    // 구현 시 추가
//    public InterviewsResponse(List<Interview> interviews) {
//        this.interviews = interviews.stream().map(InterviewResponse::new).collect(Collectors.toList());
//    }
}
