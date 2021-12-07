package com.j2kb5th.chippo.user.service;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.request.ValidateNicknameRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UpdateUserResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserRoleResponse;
import com.j2kb5th.chippo.user.controller.dto.response.ValidateNicknameResponse;
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

        return Optional.of(findUser(user.getUserId()))
                .map(u -> new UserDetailResponse(u))
                .get();
    }

    @Transactional
    @Override
    public UpdateUserResponse updateUser(SessionUser user, UpdateUserRequest request) {

        return Optional.of(findUser(user.getUserId())
                        .update(request.getNickname()))
                .map(u -> new UpdateUserResponse(u))
                .get();
    }

    @Transactional
    @Override
    public void deleteUser(SessionUser user) {
        findUser(user.getUserId()).delete();
    }

    @Override
    public ValidateNicknameResponse validateNickname(SessionUser user, ValidateNicknameRequest request) {

        Optional<User> findByNickname = userRepository.findByNickname(request.getNickname());
        boolean validate = findByNickname.isPresent() ? false : true;

        return ValidateNicknameResponse.builder()
                .beforeNickname(user.getNickname())
                .afterNickname(request.getNickname())
                .validate(validate)
                .build();
    }

    @Override
    public UserRoleResponse getUserRole(Long userId) {
        // RoleKey -> ROLE_USER / Role -> USER
        return Optional.of(findUser(userId))
                .map(user -> new UserRoleResponse(user.getRole()))
                .get();
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "탈퇴했거나 가입하지 않은 회원입니다.")
                );
    }
}
