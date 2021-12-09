package com.j2kb5th.chippo.user.controller;

import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.request.UpdateUserRequest;
import com.j2kb5th.chippo.user.controller.dto.request.ValidateNicknameRequest;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UpdateUserResponse;
import com.j2kb5th.chippo.user.controller.dto.response.UserRoleResponse;
import com.j2kb5th.chippo.user.controller.dto.response.ValidateNicknameResponse;
import com.j2kb5th.chippo.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "유저(User)", description = "유저 API")
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 조회", description = "로그인된 세션 유저 정보를 조회합니다.")
    @Transactional(readOnly = true)
    @GetMapping("/user-info")
    public ResponseEntity<UserDetailResponse> getUserDetail(@LoginUser SessionUser user) {

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(userService.getUserDetail(user));
    }

    @Operation(summary = "유저 정보 수정", description = "id를 이용해 해당 유저의 정보를 수정합니다.")
    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUserInfo(
            @Parameter(description = "유저 ID") @PathVariable Long userId,
            @LoginUser SessionUser user,
            @Valid @RequestBody UpdateUserRequest request
    ) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(userService.updateUser(user, request));
        // 세션값 변경 필요
    }

    @Operation(summary = "유저 삭제(체크)", description = "id를 이용해 해당 유저의 deleted 상태를 true로 변경합니다. (실제 삭제 X)")
    @PatchMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "유저 ID") @PathVariable Long userId,
            @LoginUser SessionUser user
    ) {
        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
        // 로그아웃 처리 할 것!
    }

    @Operation(summary = "닉네임 중복검사", description = "request body에 입력한 닉네임이 이미 존재하는지 검사합니다.")
    @PostMapping("/users/validate-nickname")
    public ResponseEntity<ValidateNicknameResponse> validateNickname(
            @LoginUser SessionUser user,
            @Valid @RequestBody ValidateNicknameRequest request
    ) {
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

    @Operation(summary = "유저 권한 정보 불러오기", description = "id를 이용해 해당 유저의 권한을 불러옵니다.")
    @Transactional(readOnly = true)
    @GetMapping("/users/{userId}/role")
    public ResponseEntity<UserRoleResponse> getUserRole(
            @Parameter(description = "유저 ID") @PathVariable Long userId,
            @LoginUser SessionUser user
    ) {

        if (user == null || user.getUserId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(userService.getUserRole(userId));
    }
}
