package com.j2kb5th.chippo.preanswer.service;

import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;

public interface PreAnswerService {

    PreAnswer save(SavePreAnswerRequest request, Long interviewId);
}
