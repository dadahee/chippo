package com.j2kb5th.chippo.thumb.controller;

import com.j2kb5th.chippo.thumb.controller.dto.response.CheckThumbResponse;
import com.j2kb5th.chippo.thumb.controller.dto.response.ThumbResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;

@Tag(name = "따봉(좋아요)", description = "따봉 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}")
@RestController
public class ThumbController {

    @Operation(summary = "따봉 저장", description = "해당 id의 기술면접에 따봉(좋아요)을 등록합니다.")
    @PostMapping("/thumbs")
    public ResponseEntity<ThumbResponse> saveThumb(
            UriComponentsBuilder uriBuilder,
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        ThumbResponse testResponse = new ThumbResponse((123L), LocalDateTime.now());

        URI uri = uriBuilder.path("/api/interviews/{interviewId}").build().toUri();
        return ResponseEntity.created(uri).body(testResponse);
    }

    @Operation(summary = "따봉 취소", description = "해당 id의 기술면접에서, 해당 id의 따봉(좋아요)을 취소합니다.")
    @DeleteMapping("/thumbs/{thumbId}")
    public ResponseEntity<Void> deleteThumb(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Parameter(description = "따봉 ID") @PathVariable(name = "thumbId") Long thumbId
    ){
        return ResponseEntity.noContent().build();
    }

    // 특정 인터뷰에 대해 유저의 따봉 여부 판단
    // interview 조회 시 줄 예정이지만, 혹시 몰라 추가함
    @Operation(summary = "따봉 여부 판단(임시용)",
            description = "현재는 기술면조 단건 조회 시 따봉 여부가 함께 전달됩니다. 혹시 몰라 추가해둔 API입니다.")
    @GetMapping("/users/{userId}/thumbs")
    public ResponseEntity<CheckThumbResponse> checkThumb (
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
        @Parameter(description = "유저 ID") @PathVariable(name = "userId") Long userId
    ){
        ThumbResponse testThumbResponse = new ThumbResponse(123L, LocalDateTime.now());
        CheckThumbResponse testCheckResponse = new CheckThumbResponse(false, testThumbResponse);
        return ResponseEntity.ok(testCheckResponse);
    }
}
