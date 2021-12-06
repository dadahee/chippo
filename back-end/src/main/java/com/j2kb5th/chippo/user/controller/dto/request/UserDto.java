package com.j2kb5th.chippo.user.controller.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {

    private Long id;
    private String email;
    private String nickname;

    @Builder
    public UserDto(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

}
