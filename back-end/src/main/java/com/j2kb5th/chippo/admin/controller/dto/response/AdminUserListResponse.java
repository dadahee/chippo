package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 임시용
public class AdminUserListResponse {

    private final List<AdminUserResponse> users;

//    public AdminUserListResponse(List<User> user){
//        this.users = user.stream()
//                .map(AdminUserResponse::new).collect(Collectors.toList());
//    }
}
