package com.j2kb5th.chippo.preanswer.controller.dto.request;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class SavePreAnswerRequest {

    @NotNull
    private Long userId;

    @Size(max = 300)
    @NotNull
    private String content;

    public PreAnswer toEntity(User user, Interview interview) {
        return PreAnswer.builder()
                .content(content)
                .user(user)
                .interview(interview)
                .build();
    }
}
