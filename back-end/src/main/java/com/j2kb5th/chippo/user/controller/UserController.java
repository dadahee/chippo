package com.j2kb5th.chippo.user.controller;

import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.interview.controller.dto.response.InterviewListResponse;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.request.ValidateNicknameRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserRoleResponse;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user-info")
    public ResponseEntity<UserDetailResponse> getUserDetail(@LoginUser SessionUser user) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(userService.getUserDetail(user), HttpStatus.OK);
    }

    @PutMapping ("/users/{userId}")
    public ResponseEntity<UserResponse> updateUserInfo(@PathVariable Long userId, @LoginUser SessionUser user, @RequestBody UpdateUserRequest request) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(userService.update(user, request), HttpStatus.OK);
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long userId, @LoginUser SessionUser user) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(userService.withdraw(user), HttpStatus.OK);
    }

    @PostMapping("/users/validate-nickname")
    public ResponseEntity<Boolean> validateNickname(@LoginUser SessionUser user, @RequestBody ValidateNicknameRequest request) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if (request.equals(user.getNickname())) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        // true = 닉네임 중복. 사용 불가.
        // false = 닉네임 사용 가능.
        return new ResponseEntity<>(userService.validateNickname(request), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/role")
    public ResponseEntity<UserRoleResponse> getUserRole(@PathVariable Long userId, @LoginUser SessionUser user) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(userService.getUserRole(userId), HttpStatus.OK);
    }
}
