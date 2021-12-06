package com.j2kb5th.chippo.admin.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class AdminInterviewRequest {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @Size(max = 150)
    @NotEmpty
    private String question;

    @Size(max = 300)
    @NotEmpty
    private String answer;

    @Size(max = 300)
    @NotEmpty
    private String extraInfo;

    // 인터뷰 태그 정보
}
