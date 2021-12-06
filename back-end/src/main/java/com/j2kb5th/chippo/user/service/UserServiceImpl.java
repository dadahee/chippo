package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserResponse;
import com.j2kb5th.chippo.user.domain.User;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailResponse getUserDetail(SessionUser user) {

        return findUser(user.getUserId()).map(u -> new UserDetailResponse(u)).get();
    }

    @Transactional
    @Override
    public UserResponse update(SessionUser user, UpdateUserRequest request) {

        return Optional.of(findUser(user.getUserId()).get()
                        .update(request.getNickname()))
                .map(u -> new UserResponse(u))
                .get();
    }

    @Transactional
    @Override
    public Long withdraw(SessionUser user) {
        findUser(user.getUserId()).get().delete();

        return user.getUserId();
    }

    private Optional<User> findUser(Long userId) {
        Optional<User> userFoundById = userRepository.findById(userId);

        if (!userFoundById.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "탈퇴했거나 가입하지 않은 회원입니다.");
        }

        return userFoundById;
    }
}
