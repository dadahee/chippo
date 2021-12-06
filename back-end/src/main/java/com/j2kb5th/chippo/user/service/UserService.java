package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserResponse;

public interface UserService {

    UserDetailResponse getUserDetail(SessionUser user);

    UserResponse update(SessionUser user, UpdateUserRequest request);

    Long withdraw(SessionUser user);
}
