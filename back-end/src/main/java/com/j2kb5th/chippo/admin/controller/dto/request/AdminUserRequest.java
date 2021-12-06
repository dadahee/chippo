package com.j2kb5th.chippo.admin.controller.dto.request;

import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RequiredArgsConstructor // 임시
@Getter
public class AdminUserRequest {

    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nickname;

    @Email
    @Size(max = 50)
    private String email;

    private Role role;
    private Provider provider;
    private boolean deleted;
}
