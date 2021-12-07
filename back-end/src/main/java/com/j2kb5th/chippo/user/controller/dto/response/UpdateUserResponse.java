package com.j2kb5th.chippo.user.controller.dto.response;

import com.j2kb5th.chippo.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UpdateUserResponse {

    private final Long id;
    private final String email;
    private final String nickname;

    public UpdateUserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }

}
