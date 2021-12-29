package com.j2kb5th.chippo.comment.service;

import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findCommentsByInterviewId(Long interviewId);
    Comment saveComment(CommentRequest commentRequest, Long interviewId);
    void deleteComment(Long userId, Long commentId, Long interviewId);
}
