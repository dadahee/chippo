package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 추후 제거
@Getter
public class UpdateAdminUserResponse {
    private final Long id;
    private final String nickname;
    private final String email;
    private final String password;
    private final Role role;
    private final Provider provider;
    private final boolean deleted;

    public UpdateAdminUserResponse(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.deleted = user.isDeleted();
    }
}
