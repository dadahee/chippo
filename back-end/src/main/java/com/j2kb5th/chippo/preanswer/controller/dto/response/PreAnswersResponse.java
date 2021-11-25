package com.j2kb5th.chippo.preanswer.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor // 임시용
public class PreAnswersResponse {
    private final List<PreAnswerResponse> preAnswers;
}
