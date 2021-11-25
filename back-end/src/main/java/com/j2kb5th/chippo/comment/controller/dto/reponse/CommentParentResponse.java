package com.j2kb5th.chippo.comment.controller.dto.reponse;

import com.j2kb5th.chippo.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentParentResponse {
    private final Long parent;

    public CommentParentResponse(Comment comment) {
        this.parent = comment.getParent().getId(); // 수정 필요
    }
}
