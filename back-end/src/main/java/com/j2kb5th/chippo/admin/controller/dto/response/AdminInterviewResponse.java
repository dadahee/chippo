package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 임시용
public class AdminInterviewResponse {

    private final Long id;
    private final UserResponse user;
    private final String question;
    private final String answer;
    private final String extraInfo;
    private final List<AdminTagDetailResponse> interviewTags;
    private final List<AdminThumbResponse> thumbs;
    private final List<AdminCommentResponse> comments;

    public AdminInterviewResponse(Interview interview) {
        if (Objects.isNull(interview)){
            // 처리 필요
        }
        this.id = interview.getId();
        this.user = new UserResponse(interview.getUser());
        this.question = interview.getQuestion();
        this.answer = interview.getAnswer();
        this.extraInfo = interview.getExtraInfo();
        this.interviewTags = interview.getInterviewTags().stream()
                .map((interviewTag) -> new AdminTagDetailResponse(interviewTag.getTag()))
                .collect(Collectors.toList());
        this.thumbs = interview.getThumbs().stream()
                .map(AdminThumbResponse::new).collect(Collectors.toList());
        this.comments = interview.getComments().stream()
                .map(AdminCommentResponse::new).collect(Collectors.toList());
    }
}
