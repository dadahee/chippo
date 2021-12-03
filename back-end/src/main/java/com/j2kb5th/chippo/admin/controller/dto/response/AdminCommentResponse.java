package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.domain.Interview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor // 임시용
@Getter
public class AdminCommentResponse {
    private final Long id;
    private final UserResponse user;
    private final String content;
    private final LocalDateTime createdAt;

    public AdminCommentResponse(Comment comment){
        this.id = comment.getId();
        this.user = new UserResponse(comment.getUser());
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
