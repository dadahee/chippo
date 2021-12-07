package com.j2kb5th.chippo.user.controller.dto.response;

import com.j2kb5th.chippo.user.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRoleResponse {

    private Role role;

}
