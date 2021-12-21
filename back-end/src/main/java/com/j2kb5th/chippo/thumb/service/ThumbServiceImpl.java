package com.j2kb5th.chippo.thumb.service;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import com.j2kb5th.chippo.thumb.repository.ThumbRepository;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class ThumbServiceImpl implements ThumbService {

    private final ThumbRepository thumbRepository;
    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;

    @Transactional
    @Override
    public Thumb saveThumb(Long interviewId, Long userId) {
        User user = userRepository.findById(userId).get();
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 게시물입니다."));

        Thumb thumb = Thumb.builder()
                .user(user)
                .interview(interview)
                .build();

        return thumbRepository.save(thumb);
    }

    @Override
    public void cancelThumb(Long interviewId, Long userId) {

        Thumb thumb = thumbRepository.findByInterviewAndUser(interviewId, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "회원님의 좋아요 기록이 없습니다."));

        thumbRepository.delete(thumb);
    }

    @Override
    public boolean checkThumb(Long interviewId, Long userId) {
        return thumbRepository.findByInterviewAndUser(interviewId, userId).isPresent();
    }

}
