package com.j2kb5th.chippo.preanswer.controller;

import com.j2kb5th.chippo.preanswer.controller.dto.request.PreAnswerRequest;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswerResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswerUserResponse;
import com.j2kb5th.chippo.preanswer.controller.dto.response.PreAnswersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
                1L,
                "저는 말하는 감자라 모르겠어요..",
                new PreAnswerUserResponse(9L, "말하는감자")
        ));
        preAnswers.add(new PreAnswerResponse(
                2L,
                "저는 말하는 고구마라 알지만 비밀이에요...",
                new PreAnswerUserResponse(10L, "말하는고구마")
        ));
        return ResponseEntity.ok(new PreAnswersResponse(preAnswers));
    }

    @PostMapping
    public ResponseEntity<PreAnswerResponse> save(
        @PathVariable(name = "interviewId") Long interviewId,
        @Valid @RequestBody PreAnswerRequest preAnswerRequest
    ){
        PreAnswerResponse response = new PreAnswerResponse(11L, "리덕스는 어쩌구저쩌구 리덕스 사가는어쩌구저쩌구", new PreAnswerUserResponse(10L, "리액트개발자"));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{preAnswerId}")
    public ResponseEntity<PreAnswerResponse> update(
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody PreAnswerRequest preAnswerRequest
    ){
        PreAnswerResponse response = new PreAnswerResponse(12L, "nest.js란 어쩌구저쩌구", new PreAnswerUserResponse(11L, "노드개발자"));
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
