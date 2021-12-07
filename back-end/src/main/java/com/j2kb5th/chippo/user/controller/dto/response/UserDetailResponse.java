package com.j2kb5th.chippo.user.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class UserDetailResponse {

    private final Long id;
    private final String email;
    private final String nickname;
    private final Role role;
    private final Provider provider;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;

    public UserDetailResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.createdAt = user.getCreatedAt();
    }

}
