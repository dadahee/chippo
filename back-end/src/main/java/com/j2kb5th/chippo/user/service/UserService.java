package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UserDto;

public interface UserService {

    UserDto getUserDetail(SessionUser user);
}
