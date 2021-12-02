package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // 임시 어노테이션
public class InterviewPreAnswerResponse {
    private final Long id;
    private final String content;
    private final UserResponse user;
    private final LocalDateTime updatedAt;

    public InterviewPreAnswerResponse(PreAnswer preAnswer) {
        this.id = preAnswer.getId();
        this.content = preAnswer.getContent();
        this.user = new UserResponse(preAnswer.getUser());
        this.updatedAt = preAnswer.getUpdatedAt();
    }
}
