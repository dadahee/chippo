package com.j2kb5th.chippo.user.controller;

import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.user.controller.dto.response.UserDetailResponse;
import com.j2kb5th.chippo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/user-info")
    public ResponseEntity<UserDetailResponse> getUserDetail() {

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userService.getUserDetail(user), HttpStatus.OK);
    }
}
