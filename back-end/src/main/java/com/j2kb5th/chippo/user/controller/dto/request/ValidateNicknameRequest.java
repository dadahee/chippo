package com.j2kb5th.chippo.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ValidateNicknameRequest {

    @NotBlank
    private String nickname;

}
