package com.j2kb5th.chippo.interview.controller.dto.response;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class InterviewThumbResponse {

    @NotNull
    private final boolean clicked;

    @NotNull
    private final Long count;
}
