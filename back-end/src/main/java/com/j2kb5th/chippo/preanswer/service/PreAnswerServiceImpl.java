package com.j2kb5th.chippo.preanswer.service;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import com.j2kb5th.chippo.preanswer.repository.PreAnswerRepository;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class PreAnswerServiceImpl implements PreAnswerService {

    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;
    private final PreAnswerRepository preAnswerRepository;

    @Override
    public PreAnswer save(SavePreAnswerRequest request, Long interviewId) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "탈퇴했거나 가입하지 않은 회원입니다."));
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 면접 질문입니다."));

        return preAnswerRepository.save(request.toEntity(user, interview));
    }
}
