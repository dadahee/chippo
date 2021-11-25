package com.j2kb5th.chippo.comment.controller.dto.reponse;

import com.j2kb5th.chippo.comment.domain.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // dummy data용 임시
public class CommentUserResponse {
    private final Long id;
    private final String nickname;

    public CommentUserResponse(Comment comment) {
        this.id = comment.getUser().getId(); // 수정 필요
        this.nickname = comment.getUser().getNickname(); // 수정 필요
    }
}
