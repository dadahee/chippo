package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 임시
public class AdminUserResponse {

    private final Long id;
    private final String nickname;
    private final String email;
    private final String password;
    private final Role role;
    private final Provider provider;
    private final boolean deleted;
    private final List<AdminThumbResponse> thumbs;

    public AdminUserResponse(User user){
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.deleted = user.isDeleted();
        if (Objects.isNull(user.getThumbs())){
            // 처리
        }
        this.thumbs = user.getThumbs().stream()
                .map(AdminThumbResponse::new).collect(Collectors.toList());
    }
}



