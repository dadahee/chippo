package com.j2kb5th.chippo.comment.service;

import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.comment.repository.CommentRepository;
import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final InterviewRepository interviewRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    private Comment findCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, ErrorMessage.CO001));
    }

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
        // 유저 권한 체크: 활성화 유저이거나 관리자거나
        if (! (user.hasAuthority(requestUserId))) {
            throw new GlobalException(HttpStatus.FORBIDDEN, ErrorMessage.GL004);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findCommentsByInterviewId(Long interviewId) {
        return commentRepository.findByInterviewId(interviewId);
    }

    @Override
    public Comment saveComment(CommentRequest commentRequest, Long interviewId) {
        //// 유저
        // 조회
        User user = findUserById(commentRequest.getUserId());

        // 권한 체크
        validateUserAuthority(user, commentRequest.getUserId());

        //// 기술면접
        Interview interview = findInterviewById(interviewId);
        Comment comment = commentRequest.toEntity(user, interview);

        // 기술면접에 덧글 추가
        interview.addComment(comment);

        // 저장
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long userId, Long commentId, Long interviewId) {
        //// 유저
        // 조회
        User user = findUserById(userId);

        //// 기술면접
        Interview interview = findInterviewById(interviewId);
        Comment comment = findCommentById(commentId);

        // 권한 체크
        validateUserAuthority(user, comment.getUser().getId());
        commentRepository.delete(comment);
    }
}
