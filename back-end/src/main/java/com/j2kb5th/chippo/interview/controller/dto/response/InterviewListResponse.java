package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.interview.domain.Interview;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class InterviewListResponse {
    private final List<InterviewResponse> interviews;

    public InterviewListResponse(List<Interview> interviews) {
        this.interviews = interviews.stream().map(InterviewResponse::new).collect(Collectors.toList());
    }
}
