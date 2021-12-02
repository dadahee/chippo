package com.j2kb5th.chippo.interview.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor // 구현 후 삭제
public class InterviewListResponse {
    private final List<InterviewResponse> interviews;

    // 구현 시 추가
//    public InterviewsResponse(List<Interview> interviews) {
//        this.interviews = interviews.stream().map(InterviewResponse::new).collect(Collectors.toList());
//    }
}
