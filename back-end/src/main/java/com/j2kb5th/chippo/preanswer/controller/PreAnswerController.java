package com.j2kb5th.chippo.preanswer.controller;

import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.request.UpdatePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswerResponse;
import com.j2kb5th.chippo.preanswer.service.PreAnswerService;
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

@Tag(name = "사전답안(PreAnswer)", description = "사전답안 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/pre-answers")
@RestController
public class PreAnswerController {

    private final PreAnswerService preAnswerService;

    // 현재는 interview 조회 시 preanswer도 있으면 동시에 전달
    // 혹시 몰라 단건 조회도 첨부
    @Operation(summary = "사전답안 기술면접 및 사용자별 조회",
            description = "특정 기술면접에 대해 특정 사용자가 등록한 사전답안 게시글이 있다면 함께 전달됩니다.")
    @GetMapping({"", "/"})
    public ResponseEntity<PreAnswerResponse> findPreAnswer(
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
        @LoginUser SessionUser user
    ){
        Long userId = user == null ? 0L : user.getUserId();

        PreAnswerResponse response = null;
        try {
            response = new PreAnswerResponse(preAnswerService.getOnePreAnswer(interviewId, userId));
        } catch (NullPointerException e) {}

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "사전답안 저장", description = "요청된 정보를 사전답안으로 등록합니다.")
    @PostMapping
    public ResponseEntity<PreAnswerResponse> savePreAnswer(
        UriComponentsBuilder uriBuilder,
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
        @Valid @RequestBody SavePreAnswerRequest preAnswerRequest,
        @LoginUser SessionUser user
    ){
        if (user == null || user.getUserId() != preAnswerRequest.getUserId()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        URI uri = uriBuilder.path("/api/interviews/{interviewId}").buildAndExpand(interviewId).toUri();

        PreAnswerResponse response = new PreAnswerResponse(preAnswerService.save(preAnswerRequest, interviewId));
        return ResponseEntity.created(uri).body(response);
    }

    @Operation(summary = "사전답안 수정", description = "id를 이용해 사전답안을 수정합니다.")
    @PatchMapping("/{preAnswerId}")
    public ResponseEntity<PreAnswerResponse> updatePreAnswer(
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
        @Parameter(description = "사전답안 ID") @PathVariable(name = "preAnswerId") Long preAnswerId,
        @Valid @RequestBody UpdatePreAnswerRequest preAnswerRequest,
        @LoginUser SessionUser user
    ){
        if (user == null || preAnswerRequest.getUserId() != user.getUserId() || preAnswerRequest.getId() != preAnswerId) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        PreAnswerResponse response = new PreAnswerResponse(preAnswerService.updatePreAnswer(preAnswerRequest, interviewId));

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "사전답안 삭제", description = "id를 이용해 사전답안을 삭제합니다.")
    @DeleteMapping("/{preAnswerId}")
    public ResponseEntity<Void> deletePreAnswer(
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
        @Parameter(description = "사전답안 ID") @PathVariable(name = "preAnswerId") Long preAnswerId
    ){
        return ResponseEntity.noContent().build();
    }

}
