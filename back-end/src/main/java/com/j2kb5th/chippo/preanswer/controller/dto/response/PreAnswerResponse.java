package com.j2kb5th.chippo.preanswer.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // dummy data를 위한 임시 어노테이션 (로직 구현 후 제거)
public class PreAnswerResponse {
    private final Long id;
    private final String content;
    private final UserResponse user;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime updatedAt; // 논의 필요

    public PreAnswerResponse(PreAnswer preAnswer) {
        this.id = preAnswer.getId();
        this.content = preAnswer.getContent();
        this.user = new UserResponse(preAnswer.getUser());
        this.updatedAt = preAnswer.getUpdatedAt();
    }
}
