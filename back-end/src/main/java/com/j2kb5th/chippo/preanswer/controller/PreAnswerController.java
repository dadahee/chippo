package com.j2kb5th.chippo.preanswer.controller;

import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.request.PreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswerResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/pre-answers")
@RestController
public class PreAnswerController {

    @GetMapping
    public ResponseEntity<PreAnswersResponse> find(
        @PathVariable(name = "interviewId") Long interviewId
    ){
        List<PreAnswerResponse> preAnswers = new ArrayList<>();
        preAnswers.add(new PreAnswerResponse(
                interviewId,
                "저는 말하는 감자라 모르겠어요..",
                new UserResponse(9L, "말하는감자"),
                LocalDateTime.now()
        ));
        preAnswers.add(new PreAnswerResponse(
                interviewId,
                "저는 말하는 고구마라 알지만 비밀이에요...",
                new UserResponse(10L, "말하는고구마"),
                LocalDateTime.now()
        ));
        return ResponseEntity.ok(new PreAnswersResponse(preAnswers));
    }

    @PostMapping
    public ResponseEntity<PreAnswerResponse> save(
        UriComponentsBuilder uriBuilder,
        @PathVariable(name = "interviewId") Long interviewId,
        @Valid @RequestBody PreAnswerRequest preAnswerRequest
    ){
        URI uri = uriBuilder.path("/api/interviews/{interviewId}/pre-answers").buildAndExpand(interviewId).toUri();
        PreAnswerResponse response = new PreAnswerResponse(interviewId, preAnswerRequest.getContent(), new UserResponse(10L, "리액트개발자"), LocalDateTime.now());
        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/{preAnswerId}")
    public ResponseEntity<PreAnswerResponse> update(
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody PreAnswerRequest preAnswerRequest
    ){
        PreAnswerResponse response = new PreAnswerResponse(interviewId, preAnswerRequest.getContent(), new UserResponse(11L, "노드개발자"), LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{preAnswerId}")
    public ResponseEntity<Void> delete(
            @PathVariable(name = "interviewId") Long interviewId,
            @PathVariable(name = "preAnswerId") Long preAnswerId
    ){
        return ResponseEntity.noContent().build();
    }

}
