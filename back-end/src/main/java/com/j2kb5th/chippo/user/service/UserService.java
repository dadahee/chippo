package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;

public interface UserService {

    UserDetailResponse getUserDetail(SessionUser user);
}
