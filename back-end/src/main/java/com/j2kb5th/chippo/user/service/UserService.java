package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.request.ValidateNicknameRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UpdateUserResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserRoleResponse;
import com.j2kb5th.chippo.user.controller.dto.response.ValidateNicknameResponse;

public interface UserService {

    UserDetailResponse getUserDetail(SessionUser user);

    UpdateUserResponse updateUser(SessionUser user, UpdateUserRequest request);

    void deleteUser(SessionUser user);

    ValidateNicknameResponse validateNickname(SessionUser user, ValidateNicknameRequest request);

    UserRoleResponse getUserRole(Long userId);
}
