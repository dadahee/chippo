package com.j2kb5th.chippo.preanswer.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 임시용
public class PreAnswerResponse {
    private final Long id;
    private final String content;
    private final PreAnswerUserResponse user;
}
