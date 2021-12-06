package com.j2kb5th.chippo.interview.controller;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewTagDetailRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.UpdateInterviewRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.UpdateInterviewTagDetailRequest;
import com.j2kb5th.chippo.interview.controller.dto.response.*;
import com.j2kb5th.chippo.interview.service.InterviewService;
import com.j2kb5th.chippo.tag.domain.TagType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Tag(name = "기술면접(Interview)", description = "기술면접 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews")
@RestController
public class InterviewController {
    private final InterviewService interviewService;

    @Operation(summary = "기술면접 단건 조회", description = "id를 이용하여 기술면접 게시글을 단건 조회합니다.")
    @GetMapping("/{interviewId}")
    public ResponseEntity<InterviewDetailResponse> findInterview(
            @PathVariable(name = "interviewId") Long interviewId
    ){
        List<InterviewCommentResponse> testComments = new ArrayList<>();
        testComments.add(new InterviewCommentResponse(1L, new UserResponse(123L, "카카오꿈나무"),
                "헉 정말 좋은 답변이네요!", LocalDateTime.now()));
        testComments.add(new InterviewCommentResponse(2L, new UserResponse(123L, "배민에서 탈주한 사람"),
                "여기저기거기에서 본 면접 질문과 비슷하네요.", LocalDateTime.now()));

        List<InterviewTagDetailResponse> testTags = new ArrayList<>();
        testTags.add(new InterviewTagDetailResponse(1L, TagType.COMPANY, "카카오"));
        testTags.add(new InterviewTagDetailResponse(2L, TagType.TECHSTACK, "프론트엔드"));

        return ResponseEntity.ok(new InterviewDetailResponse(
                interviewId,
                new UserResponse(101L, "면접본사람"),
                "카카오 1024번 공채 면접 질문 1번: 프로그래밍을 왜 시작했나요?",
                "어려서부터 컴퓨터 게임을 좋아했고 어쩌구저쩌구 중학교 때 C언어의 매력에 어쩌구",
                "면접 분위기가 굉장히 유한 편이었고 면접관분들 모두 친절하셨어요",
                null,
                new InterviewThumbResponse(true, 12L),
                testTags,
                testComments,
                LocalDateTime.now()
        ));
    }


    @Operation(summary = "태그 정보로 기술면접 목록 조회",
            description = "태그명(tag_name), 태그타입(tag_type), 요청할 최대 게시글수(size)를 이용해 기술면접 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<InterviewListResponse> findInterviewsByTag(
            @RequestParam(name = "tag_name") String tagName,
            @RequestParam(name = "tag_type") String tagType,
            @RequestParam(name = "size") Long size
    ){
        List<InterviewTagDetailResponse> testTags = new ArrayList<>();
        for (Long i=1L; i<size; i++){
            testTags.add(new InterviewTagDetailResponse(i, TagType.COMPANY, tagName));
        }

        InterviewResponse testInterview = new InterviewResponse(
                12L,
                new UserResponse(101L, "태그맨날검색하는사람"),
                "JVM은 무엇이고 왜 사용하나요?",
                testTags,
                3L,
                LocalDateTime.now()
        );

        InterviewResponse testInterview2 = new InterviewResponse(
                13L,
                new UserResponse(101L, "테스트짓기어렵다"),
                "Java의 가장 큰 특징은 무엇이라 생각하나요?",
                testTags,
                3L,
                LocalDateTime.now()
        );

        InterviewResponse testInterview3 = new InterviewResponse(
                14L,
                new UserResponse(102L, "이제뭘써야하지"),
                "ORM이란 무엇인가요?",
                testTags,
                3L,
                LocalDateTime.now()
        );

        List<InterviewResponse> testInterviews = new ArrayList<>(Arrays.asList(testInterview, testInterview2, testInterview3));
        return ResponseEntity.ok(new InterviewListResponse(testInterviews));
    }

    @Operation(summary = "기술면접 저장", description = "요청한 정보를 기술면접 게시글로 등록합니다.")
    @PostMapping
    public ResponseEntity<InterviewDetailResponse> saveInterview(
            UriComponentsBuilder uriBuilder,
            @Valid @RequestBody SaveInterviewRequest interviewRequest
    ){
        List<InterviewTagDetailResponse> testTags = new ArrayList<>();
        List<SaveInterviewTagDetailRequest> tags = interviewRequest.getInterviewTags();
        for (int i=0; i<interviewRequest.getInterviewTags().size(); i++){
            testTags.add(new InterviewTagDetailResponse(1L, tags.get(i).getType(), tags.get(i).getName()));
        }

        Long testInterviewId = 100L;
        InterviewDetailResponse testResponse = new InterviewDetailResponse(
                testInterviewId,
                new UserResponse(101L, "면접본사람"),
                interviewRequest.getQuestion(),
                interviewRequest.getAnswer(),
                interviewRequest.getExtraInfo(),
                null,
                new InterviewThumbResponse(true, 9L),
                testTags,
                null,
                LocalDateTime.now()
        );

        URI uri = uriBuilder.path("/api/interviews/{interviewId}").buildAndExpand(testInterviewId).toUri();
        return ResponseEntity.created(uri).body(testResponse);
    }


    @Operation(summary = "기술면접 수정", description = "id를 이용하여 기술면접 게시글을 수정합니다.")
    @PutMapping("/{interviewId}")
    public ResponseEntity<InterviewDetailResponse> updateInterview(
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody UpdateInterviewRequest interviewRequest
    ){
        List<InterviewCommentResponse> testComments = new ArrayList<>();
        testComments.add(new InterviewCommentResponse(1L, new UserResponse(123L, "카카오꿈나무"),
                "헉 정말 좋은 답변이네요!", LocalDateTime.now()));
        testComments.add(new InterviewCommentResponse(2L, new UserResponse(123L, "배민에서 탈주한 사람"),
                "여기저기거기에서 본 면접 질문과 비슷하네요.", LocalDateTime.now()));

        List<InterviewTagDetailResponse> testTags = new ArrayList<>();
        List<UpdateInterviewTagDetailRequest> tags = interviewRequest.getInterviewTags();
        for (int i=0; i<interviewRequest.getInterviewTags().size(); i++){
            testTags.add(new InterviewTagDetailResponse(1L, tags.get(i).getType(), tags.get(i).getName()));
        }

        Long testInterviewId = 100L;

        InterviewDetailResponse testResponse = new InterviewDetailResponse(
                testInterviewId,
                new UserResponse(101L, "면접본사람"),
                interviewRequest.getQuestion(),
                interviewRequest.getAnswer(),
                interviewRequest.getExtraInfo(),
                null,
                new InterviewThumbResponse(false, 9L),
                testTags,
                testComments,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(testResponse);
    }

    @Operation(summary = "기술면접 삭제", description = "id를 이용해 기술면접 게시글을 삭제합니다. (실제 삭제)")
    @DeleteMapping("/{interviewId}")
    public ResponseEntity<Void> deleteInterview(
            @PathVariable(name = "interviewId") Long interviewId
    ){
        return ResponseEntity.noContent().build();
    }
}
