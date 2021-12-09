package com.j2kb5th.chippo.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String nickname;

}
