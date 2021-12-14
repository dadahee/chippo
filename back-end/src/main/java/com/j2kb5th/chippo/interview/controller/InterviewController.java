package com.j2kb5th.chippo.interview.controller;

import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewTagDetailRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.UpdateInterviewRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.UpdateInterviewTagDetailRequest;
import com.j2kb5th.chippo.interview.controller.dto.response.*;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.interview.service.InterviewService;
import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import com.j2kb5th.chippo.preanswer.service.PreAnswerService;
import com.j2kb5th.chippo.tag.domain.TagType;
import com.j2kb5th.chippo.thumb.service.ThumbService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Tag(name = "기술면접(Interview)", description = "기술면접 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews")
@RestController
public class InterviewController {
    private final InterviewService interviewService;
    private final PreAnswerService preAnswerService;
    private final ThumbService thumbService;

    @Operation(summary = "기술면접 단건 조회", description = "id를 이용하여 기술면접 게시글을 단건 조회합니다.")
    @GetMapping("/{interviewId}")
    public ResponseEntity<InterviewDetailResponse> findInterview(
            @LoginUser SessionUser user,
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        Interview interview = interviewService.findInterviewById(interviewId);
        PreAnswer preAnswer = preAnswerService.findPreAnswerByInterviewId(interviewId);
        boolean clicked = (user == null)? false: thumbService.checkThumb(user.getUserId(), interviewId);
        return ResponseEntity.ok(new InterviewDetailResponse(interview, preAnswer, clicked));
    }


    @Operation(summary = "태그 정보로 기술면접 목록 조회",
            description = "태그명(tag_name), 태그타입(tag_type), 요청할 최대 게시글수(size)를 이용해 기술면접 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<InterviewListResponse> findInterviewsByTag(
            @RequestParam(name = "tag_name") String tagName,
            @RequestParam(name = "tag_type") TagType tagType,
            @RequestParam(name = "size") Long size
    ) throws Exception {
        List<Interview> interviews = interviewService.findInterviewsByTag(tagName, tagType, size);
        return ResponseEntity.ok(new InterviewListResponse(interviews));
    }

    @Operation(summary = "기술면접 저장", description = "요청한 정보를 기술면접 게시글로 등록합니다.")
    @PostMapping
    public ResponseEntity<InterviewDetailResponse> saveInterview(
            @LoginUser SessionUser user,
            UriComponentsBuilder uriBuilder,
            @Valid @RequestBody SaveInterviewRequest interviewRequest
    ){
        if (user == null) {
            throw new GlobalException(HttpStatus.UNAUTHORIZED, ErrorMessage.GL003);
        }
        Interview interview = interviewService.saveInterview(interviewRequest, user.getUserId());
        InterviewDetailResponse detailResponse = new InterviewDetailResponse(interview, null, false);

        URI uri = uriBuilder.path("/api/interviews/{interviewId}").buildAndExpand(interview.getId()).toUri();
        return ResponseEntity.created(uri).body(detailResponse);
    }


    @Operation(summary = "기술면접 수정", description = "id를 이용하여 기술면접 게시글을 수정합니다.")
    @PutMapping("/{interviewId}")
    public ResponseEntity<InterviewDetailResponse> updateInterview(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody UpdateInterviewRequest interviewRequest
    ){
//        List<InterviewCommentResponse> testComments = new ArrayList<>();
//        testComments.add(new InterviewCommentResponse(1L, new UserResponse(123L, "카카오꿈나무"),
//                "헉 정말 좋은 답변이네요!", LocalDateTime.now()));
//        testComments.add(new InterviewCommentResponse(2L, new UserResponse(123L, "배민에서 탈주한 사람"),
//                "여기저기거기에서 본 면접 질문과 비슷하네요.", LocalDateTime.now()));
//
//        List<InterviewTagDetailResponse> testTags = new ArrayList<>();
//        List<UpdateInterviewTagDetailRequest> tags = interviewRequest.getInterviewTags();
//        for (int i=0; i<interviewRequest.getInterviewTags().size(); i++){
//            testTags.add(new InterviewTagDetailResponse(1L, tags.get(i).getType(), tags.get(i).getName()));
//        }
//
//        Long testInterviewId = 100L;
//
//        InterviewDetailResponse testResponse = new InterviewDetailResponse(
//                testInterviewId,
//                new UserResponse(101L, "면접본사람"),
//                interviewRequest.getQuestion(),
//                interviewRequest.getAnswer(),
//                interviewRequest.getExtraInfo(),
//                null,
//                new InterviewThumbResponse(false, 9L),
//                testTags,
//                testComments,
//                LocalDateTime.now()
//        );
//        return ResponseEntity.ok(testResponse);
        return ResponseEntity.ok(null);
    }

    @Operation(summary = "기술면접 삭제", description = "id를 이용해 기술면접 게시글을 삭제합니다. (실제 삭제)")
    @DeleteMapping("/{interviewId}")
    public ResponseEntity<Void> deleteInterview(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        return ResponseEntity.noContent().build();
    }
}
