package com.j2kb5th.chippo.global.controller.dto;

import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 임시용
public class UserResponse {
    private final Long id;
    private final String nickname;

    public UserResponse(User user) {
        if (user == null) {
            // 처리 필요
        }
        this.id = user.getId();
        this.nickname = user.getNickname();
    }
}
