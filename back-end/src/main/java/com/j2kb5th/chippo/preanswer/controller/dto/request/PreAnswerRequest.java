package com.j2kb5th.chippo.preanswer.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class PreAnswerRequest {

    @Size(max = 300)
    @NotNull
    private String content;
}
