package com.j2kb5th.chippo.interview.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor // 접근제한 추가 필요
@Getter
public class UpdateInterviewRequest {

    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @Size(max = 150)
    @NotNull
    private String question;

    @Size(max = 300)
    @NotNull
    private String answer;

    @Size(max = 300)
    @NotNull
    private String extraInfo;

    @NotNull
    private boolean visible;

    private List<UpdateInterviewTagDetailRequest> interviewTags;

    // toEntity 삽입
}
