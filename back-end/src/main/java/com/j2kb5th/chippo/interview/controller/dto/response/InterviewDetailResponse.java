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
public class InterviewDetailResponse {

    private final Long id;
    private final UserResponse user;
    private final String question;
    private final String answer;
    private final String extra_info;
    private final boolean visible;

    private final List<InterviewTagResponse> interviewTags;
    private final List<InterviewCommentResponse> comments;
    private final Long likeCount;

    @JsonFormat(pattern = "yyyy-NN-dd`T`HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime updatedAt;

    public InterviewDetailResponse(Interview interview) {
        this.id = interview.getId();
        this.user = new UserResponse(interview.getUser());
        this.question = interview.getQuestion();
        this.answer = interview.getAnswer();
        this.extra_info = interview.getExtra_info();
        this.visible = interview.isVisible();
        this.interviewTags = interview.getInterviewTags().stream().map(InterviewTagResponse::new).collect(Collectors.toList());
        this.likeCount = interview.getLikes().stream().count();
        this.comments = interview.getComments().stream().map(InterviewCommentResponse::new).collect(Collectors.toList());
        this.updatedAt = interview.getUpdatedAt();
    }
}
