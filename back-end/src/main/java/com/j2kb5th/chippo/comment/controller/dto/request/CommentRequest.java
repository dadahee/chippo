package com.j2kb5th.chippo.comment.controller.dto.request;

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

    // toEntity 삽입
}
