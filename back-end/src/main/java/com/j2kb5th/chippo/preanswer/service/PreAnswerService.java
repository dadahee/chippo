package com.j2kb5th.chippo.preanswer.service;

import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.request.UpdatePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;

public interface PreAnswerService {

    PreAnswer savePreAnswer(SavePreAnswerRequest request, Long interviewId);

    PreAnswer findUserPreAnswer(Long interviewId, Long userId);

    PreAnswer updatePreAnswer(UpdatePreAnswerRequest request, Long interviewId);

    void deletePreAnswer(Long interviewId, Long preAnswerId, Long userId);
}
