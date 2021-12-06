package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailResponse getUserDetail(SessionUser user) {
        Optional<User> userFoundById = userRepository.findById(user.getUserId());

        if (!userFoundById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "탈퇴했거나 가입하지 않은 회원입니다.");
        }

        return userFoundById.map(u -> new UserDetailResponse(u)).get();
    }
}
