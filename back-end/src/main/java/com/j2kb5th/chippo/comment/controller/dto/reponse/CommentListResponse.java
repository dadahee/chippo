package com.j2kb5th.chippo.comment.controller.dto.reponse;

import com.j2kb5th.chippo.comment.domain.Comment;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CommentListResponse {
    private final List<CommentResponse> comments;

    public CommentListResponse(List<Comment> comments) {
        this.comments = comments.stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
}
