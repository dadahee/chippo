package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateAdminInterviewResponse {
    private final Long id;
    private final UserResponse user;
    private final String question;
    private final String answer;
    private final String extraInfo;

    public UpdateAdminInterviewResponse(Interview interview){
        // 예외처리
        this.id = interview.getId();
        this.user = new UserResponse(interview.getUser());
        this.question = interview.getQuestion();
        this.answer = interview.getAnswer();
        this.extraInfo = interview.getExtraInfo();
    }
}
