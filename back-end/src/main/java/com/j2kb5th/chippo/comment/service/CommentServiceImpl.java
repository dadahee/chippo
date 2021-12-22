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

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByInterviewId(Long interviewId) {
        return commentRepository.findByInterviewId(interviewId);
    }

    @Override
    public Comment saveComment(CommentRequest commentRequest, Long interviewId) {
        return null;
    }

    @Override
    public void deleteComment(Long commentId, Long interviewId) {
        return;
    }
}
