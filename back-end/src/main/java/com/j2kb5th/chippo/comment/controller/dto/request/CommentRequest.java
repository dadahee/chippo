package com.j2kb5th.chippo.comment.controller.dto.request;

import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CommentRequest {

    @NotNull
    private Long userId;

    @Size(max = 300)
    @NotNull
    private String content;

    public Comment toEntity(User user, Interview interview) {
        return Comment.builder()
                .user(user)
                .content(content)
                .interview(interview)
                .build();
    }
}
