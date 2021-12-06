package com.j2kb5th.chippo.user.controller.dto.response;

import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDetailResponse {

    private Long id;
    private String email;
    private String nickname;
    private Role role;
    private Provider provider;
    private LocalDateTime createdAt;

    @Builder
    public UserDetailResponse(Long id, String email, String nickname, Role role, Provider provider, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
        this.provider = provider;
        this.createdAt = createdAt;
    }

    public UserDetailResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.createdAt = user.getCreatedAt();
    }

}
