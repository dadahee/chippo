package com.j2kb5th.chippo.preanswer.service;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.request.UpdatePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import com.j2kb5th.chippo.preanswer.repository.PreAnswerRepository;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class PreAnswerServiceImpl implements PreAnswerService {

    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;
    private final PreAnswerRepository preAnswerRepository;

    @Override
    public PreAnswer savePreAnswer(SavePreAnswerRequest request, Long interviewId) {
        User user = findByUserId(request.getUserId());
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 면접 질문입니다."));

        return preAnswerRepository.save(request.toEntity(user, interview));
    }

    @Transactional(readOnly = true)
    @Override
    public PreAnswer findUserPreAnswer(Long interviewId, Long userId) {

        return preAnswerRepository.findByIdAndUserId(interviewId, userId).get();
    }

    @Transactional
    @Override
    public PreAnswer updatePreAnswer(UpdatePreAnswerRequest request, Long interviewId) {

        return findByPreAnswerId(request.getId()).update(request.getContent());
    }

    @Transactional
    @Override
    public void deletePreAnswer(Long interviewId, Long preAnswerId, Long userId) {
        PreAnswer preAnswer = findByPreAnswerId(preAnswerId);
        User user = findByUserId(userId);

        if (interviewId != preAnswer.getInterview().getId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if ((user.getRole() != Role.ADMIN) && (user.getId() != preAnswer.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        preAnswerRepository.delete(preAnswer);
    }

    private PreAnswer findByPreAnswerId(Long preAnswerId) {
        return preAnswerRepository.findById(preAnswerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 사전답변입니다."));
    }

    private User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "탈퇴했거나 가입하지 않은 회원입니다."));
    }
}
