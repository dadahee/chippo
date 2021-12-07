package com.j2kb5th.chippo.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {

    @NotBlank
    private String nickname;

}
