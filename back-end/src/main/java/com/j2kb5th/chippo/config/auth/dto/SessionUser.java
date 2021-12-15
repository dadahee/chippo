package com.j2kb5th.chippo.config.auth.dto;

import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class SessionUser implements Serializable {

    private Long userId;
    private String email;
    private String nickname;
    private Role role;

    public SessionUser(User user) {
        this.userId = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRole();
    }
}
