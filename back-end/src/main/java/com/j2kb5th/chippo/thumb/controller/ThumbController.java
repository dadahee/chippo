package com.j2kb5th.chippo.thumb.controller;

import com.j2kb5th.chippo.thumb.controller.dto.request.ThumbRequest;
import com.j2kb5th.chippo.thumb.controller.dto.response.CheckThumbResponse;
import com.j2kb5th.chippo.thumb.controller.dto.response.ThumbResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}")
@RestController
public class ThumbController {

    @PostMapping("/thumbs")
    public ResponseEntity<ThumbResponse> saveThumb(
            UriComponentsBuilder uriBuilder,
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody ThumbRequest thumbRequest
    ){
        ThumbResponse testResponse = new ThumbResponse((123L), LocalDateTime.now());

        URI uri = uriBuilder.path("/api/interviews/{interviewId}").build().toUri();
        return ResponseEntity.created(uri).body(testResponse);
    }

    @DeleteMapping("/thumbs/{thumbId}")
    public ResponseEntity<Void> deleteThumb(
            @PathVariable(name = "interviewId") Long interviewId,
            @PathVariable(name = "thumbId") Long thumbId
    ){
        return ResponseEntity.noContent().build();
    }

    // 특정 인터뷰에 대해 유저의 따봉 여부 판단
    // interview 조회 시 줄 예정이지만, 혹시 몰라 추가함
    @GetMapping("/users/{userId}/thumbs")
    public ResponseEntity<CheckThumbResponse> checkThumb (
        @PathVariable(name = "interviewId") Long interviewId,
        @PathVariable(name = "userId") Long userId
    ){
        ThumbResponse testThumbResponse = new ThumbResponse(123L, LocalDateTime.now());
        CheckThumbResponse testCheckResponse = new CheckThumbResponse(false, testThumbResponse);
        return ResponseEntity.ok(testCheckResponse);
    }
}
