package com.j2kb5th.chippo.admin.controller.dto.request;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class AdminInterviewRequest {
    private Long id;
    private Long userId;

    @Size(max = 150)
    private String question;

    @Size(max = 300)
    private String answer;

    @Size(max = 300)
    private String extraInfo;
}
