package com.j2kb5th.chippo.preanswer.controller.dto.response;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // 임시용
public class PreAnswerResponse {
    private final Long id;
    private final String content;
    private final UserResponse user;
    private final LocalDateTime updatedAt; // 논의 필요
}
