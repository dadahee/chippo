package com.j2kb5th.chippo.admin.controller;

import com.j2kb5th.chippo.admin.controller.dto.request.AdminInterviewRequest;
import com.j2kb5th.chippo.admin.controller.dto.response.*;
import com.j2kb5th.chippo.admin.controller.dto.request.AdminUserRequest;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "관리자(Admin)", description = "관리자 API")
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Operation(summary = "전체 유저 조회", description = "전체 유저 정보를 조회합니다.")
    @GetMapping("/users")
    public ResponseEntity<AdminUserListResponse> findAllUsersWithAdmin(){
        List<AdminUserResponse> testUsers = new ArrayList<>();

        List<AdminThumbResponse> testThumb = new ArrayList<>();
        testThumb.add(new AdminThumbResponse(11L, 3L, LocalDateTime.now()));
        testThumb.add(new AdminThumbResponse(12L, 4L, LocalDateTime.now()));
        testThumb.add(new AdminThumbResponse(13L, 5L, LocalDateTime.now()));
        testThumb.add(new AdminThumbResponse(14L, 6L, LocalDateTime.now()));

        testUsers.add(new AdminUserResponse(123L, "개발곰발","test1@test.com", null,
                Role.USER, Provider.GOOGLE, false, new ArrayList<>()));
        testUsers.add(new AdminUserResponse(124L, "발발개발", "test2@test.com", null,
                Role.BLOCKED, Provider.NAVER, true, new ArrayList<>()));
        testUsers.add(new AdminUserResponse(125L, "손발개발", "test3@test.com", null,
                Role.USER, Provider.NAVER, false, new ArrayList<>()));
        testUsers.add(new AdminUserResponse(126L, "곰곰문문", "test4@test.com", "보통은해시값이지만일단넣어봄",
                Role.ADMIN, Provider.GOOGLE, false, new ArrayList<>()));
        AdminUserListResponse testUserListResponse = new AdminUserListResponse(testUsers);
        return ResponseEntity.ok(testUserListResponse);
    }

    @Operation(summary = "유저 정보 수정", description = "id를 이용하여 유저 정보를 수정합니다.")
    @PutMapping("/users/{userId}")
    public ResponseEntity<UpdateAdminUserResponse> updateUserWithAdmin(
            @Parameter(description = "유저 ID") @PathVariable(name = "userId") Long userId,
            @Valid @RequestBody AdminUserRequest userRequest
    ){
        UpdateAdminUserResponse testUserResponse = new UpdateAdminUserResponse(123L, "개발곰발",
                "test@test.com", null, Role.USER, Provider.GOOGLE, false);
        return ResponseEntity.ok(testUserResponse);
    }

    @Operation(summary = "유저 삭제", description = "id를 이용하여 유저를 삭제합니다(실제 삭제X, 삭제여부를 1로 변경)")
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUserWithAdmin(
            @Parameter(description = "유저 ID") @PathVariable(name = "userId") Long userId
    ){
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "전체 기술면접 조회", description = "전체 기술면접 게시글 목록을 조회합니다.")
    @GetMapping("/interviews")
    public ResponseEntity<AdminInterviewListResponse> findAllInterviewsWithAdmin(){
        UserResponse testUser1 = new UserResponse(123L, "개발곰발");
        UserResponse testUser2 = new UserResponse(124L, "개발새발");
        UserResponse testUser3 = new UserResponse(125L, "개발닭발");
        UserResponse testUser4 = new UserResponse(126L, "개발양발");

        List<AdminTagDetailResponse> testTag1 = new ArrayList<>();
        testTag1.add(new AdminTagDetailResponse(1L, TagType.TECHSTACK, "java"));
        testTag1.add(new AdminTagDetailResponse(2L, TagType.COMPANY, "네이버"));
        testTag1.add(new AdminTagDetailResponse(3L, TagType.POSITION, "백엔드"));

        List<AdminTagDetailResponse> testTag2 = new ArrayList<>();
        testTag2.add(new AdminTagDetailResponse(1L, TagType.TECHSTACK, "reactjs"));
        testTag2.add(new AdminTagDetailResponse(2L, TagType.COMPANY, "카카오"));
        testTag2.add(new AdminTagDetailResponse(3L, TagType.POSITION, "프론트엔드"));

        List<AdminTagDetailResponse> testTag3 = new ArrayList<>();
        testTag3.add(new AdminTagDetailResponse(1L, TagType.TECHSTACK, "nodejs"));
        testTag3.add(new AdminTagDetailResponse(2L, TagType.COMPANY, "네이버"));
        testTag3.add(new AdminTagDetailResponse(3L, TagType.POSITION, "백엔드"));



        List<AdminInterviewResponse> testInterviews = new ArrayList<>();
        testInterviews.add(new AdminInterviewResponse(1111L,
                testUser1,
                "JVM의 정의와 장단점을 서술하세요", "JVM은 짱짱 멋진 것임",
                "면접관님이 후드티 입음",
                testTag1,
                new ArrayList<>(),
                new ArrayList<>()
        ));

        testInterviews.add(new AdminInterviewResponse(1222L,
                testUser2,
                "SPA의 원리를 브라우저 렌더링 순서에 따라 서술하세요", "어쩌구저쩌구",
                "회사 위치가 복잡함",
                testTag2,
                new ArrayList<>(),
                new ArrayList<>()
        ));

        testInterviews.add(new AdminInterviewResponse(1333L,
                testUser3,
                "npm, parcel, deno는 뭘까요?", "npm은~~~ parcel은... deno는!!!!!",
                "다음에 손코딩 문제 시킴",
                testTag3,
                new ArrayList<>(),
                new ArrayList<>()
        ));

        return ResponseEntity.ok(new AdminInterviewListResponse(testInterviews));
    }

    @Operation(summary = "기술면접 정보 수정", description = "id를 이용하여 기술면접 정보를 수정합니다.")
    @PutMapping("/interviews/{interviewId}")
    public ResponseEntity<UpdateAdminInterviewResponse> updateInterviewWithAdmin(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody AdminInterviewRequest interviewRequest
    ){
        List<AdminTagDetailResponse> testTag1 = new ArrayList<>();
        testTag1.add(new AdminTagDetailResponse(1L, TagType.TECHSTACK, "java"));
        testTag1.add(new AdminTagDetailResponse(2L, TagType.COMPANY, "네이버"));
        testTag1.add(new AdminTagDetailResponse(3L, TagType.POSITION, "백엔드"));

        UserResponse testUser1 = new UserResponse(123L, "개발곰발");
        testTag1.add(new AdminTagDetailResponse(1L, TagType.TECHSTACK, "java"));

        UpdateAdminInterviewResponse testInterviewResponse = new UpdateAdminInterviewResponse(
                interviewId,
                testUser1,
                interviewRequest.getQuestion(), interviewRequest.getAnswer(),
                interviewRequest.getExtraInfo()
        );
        return ResponseEntity.ok(testInterviewResponse);
    }

    @Operation(summary = "기술면접 삭제", description = "id를 이용하여 기술면접 게시글을 삭제합니다(실제 삭제)")
    @DeleteMapping("/interviews/{interviewId}")
    public ResponseEntity<Void> deleteInterviewWithAdmin(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        return ResponseEntity.noContent().build();
    }
}
