package com.j2kb5th.chippo.comment.controller;

import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentResponse;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentListResponse;
import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.service.CommentService;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
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
import java.util.ArrayList;
import java.util.List;

@Tag(name = "댓글(Comment)", description = "댓글 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    // 페이지네이션 구현할 때만 필요
    @Operation(summary = "댓글 목록 조회(임시용)",
            description = "페이지네이션 기능 구현 시 필요한 댓글 목록 조회 기능입니다. 현재는 기술면접 조회 시 댓글 목록이 함께 리턴됩니다.")
    @GetMapping
    public ResponseEntity<CommentListResponse> findComments(
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        //// find comments by interview id
        // commentService.findByInterviewId(interviewId);
        //// entity -> response dto & return
        // return ResponseEntity.ok(new CommentsResponse());
        List<CommentResponse> comments = new ArrayList<>();
        comments.add(new CommentResponse(
                5L,
                new UserResponse(3L, "고인물"),
                "다른 기술면접에 비해 그래도 쉬운편이네요.",
                LocalDateTime.now()
        ));

        comments.add(new CommentResponse(
                6L,
                new UserResponse(4L, "고인물"),
                "저걸 뚝딱 대답하시다니 대단해요....",
                LocalDateTime.now()
        ));

        comments.add(new CommentResponse(
                7L,
                new UserResponse(5L, "니꼴라스동생"),
                "그러니까요. 니꼴라스도 울고 가겠어요",
                LocalDateTime.now()
        ));
        return ResponseEntity.ok(new CommentListResponse(comments));
    }

    @Operation(summary = "댓글 저장", description = "요청된 정보를 댓글로 등록합니다.")
    @PostMapping
    public ResponseEntity<CommentResponse> saveComment(
            UriComponentsBuilder uriBuilder,
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody CommentRequest commentRequest
    ){
        //// save comment & get entity to response
        // Comment comment = commentService.save(interviewId, commentRequest);
        //// entity -> response dto & return
        // return ResponseEntity.ok(new CommentResponse(comment));

        CommentResponse commentResponse = new CommentResponse(1L, new UserResponse(123L, "n년차 도비"), "면접 분위기는 어땠나요?", LocalDateTime.now());

        URI uri = uriBuilder.path("/api/interviews/{interviewId}/comments").buildAndExpand(interviewId).toUri();
        return ResponseEntity.created(uri).body(commentResponse);
    }

    @Operation(summary = "댓글 수정", description = "id를 이용하여 댓글을 삭제합니다.")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Parameter(description = "댓글 ID") @PathVariable(name = "commentId") Long commentId
    ){
        //// delete comment
        // commentService.delete(interviewId, commentId);
        return ResponseEntity.noContent().build();
    }
}
