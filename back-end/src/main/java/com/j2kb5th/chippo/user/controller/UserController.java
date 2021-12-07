package com.j2kb5th.chippo.user.controller;

import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.request.ValidateNicknameRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserUpdateResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserRoleResponse;
import com.j2kb5th.chippo.user.controller.dto.response.ValidateNicknameResponse;
import com.j2kb5th.chippo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @Transactional(readOnly = true)
    @GetMapping("/user-info")
    public ResponseEntity<UserDetailResponse> getUserDetail(@LoginUser SessionUser user) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(userService.getUserDetail(user));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResponse> updateUserInfo(
            @PathVariable Long userId,
            @LoginUser SessionUser user,
            @Valid @RequestBody UpdateUserRequest request
    ) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(userService.updateUser(user, request));
        // 세션값 변경 필요
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId, @LoginUser SessionUser user) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
        // 로그아웃 처리 할 것!
    }

    @PostMapping("/users/validate-nickname")
    public ResponseEntity<ValidateNicknameResponse> validateNickname(@LoginUser SessionUser user, @Valid @RequestBody ValidateNicknameRequest request) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (request.equals(user.getNickname())) {
            return ResponseEntity.ok(ValidateNicknameResponse.builder()
                    .beforeNickname(user.getNickname())
                    .afterNickname(request.getNickname())
                    .validate(true)
                    .build());
        }

        // true = 닉네임 사용 가능
        // false = 닉네임 사용 불가.
        return ResponseEntity.ok(userService.validateNickname(user, request));
    }

    @Transactional(readOnly = true)
    @GetMapping("/users/{userId}/role")
    public ResponseEntity<UserRoleResponse> getUserRole(@PathVariable Long userId, @LoginUser SessionUser user) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(userService.getUserRole(userId));
    }
}
