package com.j2kb5th.chippo.interview.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.domain.Interview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 임시용
public class InterviewResponse {

    private final Long id;
    private final UserResponse user;
    private final String question;

    private final List<InterviewTagDetailResponse> interviewTags;
    private final Long thumbCount;

    @JsonFormat(pattern = "yyyy-NN-dd`T`HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime updatedAt;

    public InterviewResponse(Interview interview) {
        this.id = interview.getId();
        this.user = new UserResponse(interview.getUser());
        this.question = interview.getQuestion();
        this.interviewTags = interview.getInterviewTags().stream().map(InterviewTagDetailResponse::new).collect(Collectors.toList());
        this.thumbCount = interview.getThumbs().stream().count();
        this.updatedAt = interview.getUpdatedAt();
    }
}
