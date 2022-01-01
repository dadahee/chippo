package com.j2kb5th.chippo.thumb.service;

import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
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

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ThumbServiceImpl implements ThumbService {

    private final ThumbRepository thumbRepository;
    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.GL001));
    }

    private Interview findInterviewById(Long id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.GL002));
    }

    /**
     * 유저 권한 검사
     * @param user: 세션 유저에서 받아온 id를 통해 조회한 유저 정보
     * @param requestUserId: comment request에 담긴 유저 정보
     */
    private void validateUserAuthority(User user, Long requestUserId) {
        // 유저 권한 체크: 활성화 유저이거나 관리자인지 확인
        // 유저 동일 여부 체크: user의 id == requestUserId 일치 확인
        if (! (user.hasAuthority(requestUserId))) {
            throw new GlobalException(HttpStatus.FORBIDDEN, ErrorMessage.GL004);
        }
    }

    /**
     * 유저 권한 검사
     * @param user: 세션 유저에서 받아온 id를 통해 조회한 유저 정보
     */
    private void validateUserAuthority(User user) {
        // 유저 권한 체크: 활성화 유저이거나 관리자인지 확인
        if (! (user.isAdmin() || user.isActive())) {
            throw new GlobalException(HttpStatus.FORBIDDEN, ErrorMessage.GL004);
        }
    }

    @Transactional
    @Override
    public Thumb saveThumb(Long interviewId, Long userId) {
        // 기술면접  조회
        Interview interview = findInterviewById(interviewId);

        // 유저 조회
        User user = findUserById(userId);

        // 유저 권한 체크
        validateUserAuthority(user);

        // Thumb 객체 생성
        Thumb thumb = Thumb.builder()
                .user(user)
                .interview(interview)
                .createdAt(LocalDateTime.now())
                .build();

        // 저장
        return thumbRepository.save(thumb);
    }

    @Override
    public void cancelThumb(Long interviewId, Long userId, Long sessionUserId) {
        // 유저 조회
        User user = findUserById(sessionUserId);

        // 유저 권한 체크
        validateUserAuthority(user, userId);

        // 기술면접 조회
        Interview interview = findInterviewById(interviewId);

        // 따봉 조회
        Thumb thumb = thumbRepository.findByInterviewAndUser(interview.getId(), user.getId())
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.TH001));

        // 따봉 삭제
        thumbRepository.delete(thumb);
    }

    @Override
    public boolean checkThumb(Long interviewId, Long userId) {
        // 기술면접 id, 유저 id로 따봉 조회 및 존재 여부 반환
        return thumbRepository.findByInterviewAndUser(interviewId, userId).isPresent();
    }

}
