package com.j2kb5th.chippo.config.auth.dto;

import com.j2kb5th.chippo.user.domain.User;

import java.io.Serializable;

public class SessionUser implements Serializable {

    private Long userId;
    private String email;
    private String nickname;

    public SessionUser(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
