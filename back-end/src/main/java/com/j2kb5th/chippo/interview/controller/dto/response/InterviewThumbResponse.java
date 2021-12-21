package com.j2kb5th.chippo.interview.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Getter
public class InterviewThumbResponse {

    @NotNull
    private final boolean clicked;

    @NotNull
    private final Long count;
}
