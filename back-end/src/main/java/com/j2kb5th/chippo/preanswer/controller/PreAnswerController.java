package com.j2kb5th.chippo.preanswer.controller;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.request.SavePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.request.UpdatePreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/pre-answers")
@RestController
public class PreAnswerController {

    // 현재는 interview 조회 시 preanswer도 있으면 동시에 전달
    // 혹시 몰라 단건 조회도 첨부
    @GetMapping("/{preAnswerId}")
    public ResponseEntity<PreAnswerResponse> findPreAnswer(
        @PathVariable(name = "interviewId") Long interviewId
    ){
        PreAnswerResponse testPreAnswer = new PreAnswerResponse(
                interviewId,
                "저는 말하는 감자라 모르겠어요..",
                new UserResponse(9L, "말하는감자"),
                LocalDateTime.now()
        );
        return ResponseEntity.ok(testPreAnswer);
    }

    @PostMapping
    public ResponseEntity<PreAnswerResponse> savePreAnswer(
        UriComponentsBuilder uriBuilder,
        @PathVariable(name = "interviewId") Long interviewId,
        @Valid @RequestBody SavePreAnswerRequest preAnswerRequest
    ){
        URI uri = uriBuilder.path("/api/interviews/{interviewId}/pre-answers").buildAndExpand(interviewId).toUri();
        PreAnswerResponse response = new PreAnswerResponse(interviewId, preAnswerRequest.getContent(), new UserResponse(10L, "리액트개발자"), LocalDateTime.now());
        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/{preAnswerId}")
    public ResponseEntity<PreAnswerResponse> updatePreAnswer(
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody UpdatePreAnswerRequest preAnswerRequest
    ){
        PreAnswerResponse response = new PreAnswerResponse(interviewId, preAnswerRequest.getContent(), new UserResponse(11L, "노드개발자"), LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{preAnswerId}")
    public ResponseEntity<Void> deletePreAnswer(
            @PathVariable(name = "interviewId") Long interviewId,
            @PathVariable(name = "preAnswerId") Long preAnswerId
    ){
        return ResponseEntity.noContent().build();
    }

}
