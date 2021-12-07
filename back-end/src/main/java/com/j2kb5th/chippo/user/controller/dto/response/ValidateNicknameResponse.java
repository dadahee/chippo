package com.j2kb5th.chippo.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidateNicknameResponse {

    private final String beforeNickname;
    private final String afterNickname;
    private final boolean validate;

}
