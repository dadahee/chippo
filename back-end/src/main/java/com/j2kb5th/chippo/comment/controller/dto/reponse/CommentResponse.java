package com.j2kb5th.chippo.comment.controller.dto.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.comment.domain.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // dummy data용 임시
public class CommentResponse {
    private final Long id;
    private final Long parentId;
    private final CommentUserResponse user;
    private final String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime updatedAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.user = new CommentUserResponse(comment);
        this.parentId = comment.getParent().getId(); // 수정 필요
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
