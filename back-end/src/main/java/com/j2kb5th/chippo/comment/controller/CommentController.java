package com.j2kb5th.chippo.comment.controller;

import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentResponse;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentListResponse;
import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.comment.service.CommentService;
import com.j2kb5th.chippo.config.auth.LoginUser;
import com.j2kb5th.chippo.config.auth.dto.SessionUser;
import com.j2kb5th.chippo.global.exception.ErrorMessage;
import com.j2kb5th.chippo.global.exception.GlobalException;
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
import java.util.List;

@Tag(name = "댓글(Comment)", description = "댓글 API")
@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    private void validateUserAuthentication(SessionUser user) {
        if (user == null) {
            throw new GlobalException(HttpStatus.UNAUTHORIZED, ErrorMessage.GL003);
        }
    }

    // 페이지네이션 구현할 때만 필요
    @Operation(summary = "댓글 목록 조회(임시용)",
            description = "페이지네이션 기능 구현 시 필요한 댓글 목록 조회 기능입니다. 현재는 기술면접 조회 시 댓글 목록이 함께 리턴됩니다.")
    @GetMapping
    public ResponseEntity<CommentListResponse> findComments(
        @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId
    ){
        List<Comment> comments = commentService.findCommentsByInterviewId(interviewId);
        return ResponseEntity.ok(new CommentListResponse(comments));
    }

    @Operation(summary = "댓글 저장", description = "요청된 정보를 댓글로 등록합니다.")
    @PostMapping
    public ResponseEntity<CommentResponse> saveComment(
            @Parameter(hidden = true) @LoginUser SessionUser user,
            UriComponentsBuilder uriBuilder,
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody CommentRequest commentRequest
    ){
        // validate user
        validateUserAuthentication(user);

        //// save comment & get entity to response
        Comment comment = commentService.saveComment(commentRequest, interviewId);

        URI uri = uriBuilder.path("/api/interviews/{interviewId}/comments").buildAndExpand(interviewId).toUri();
        return ResponseEntity.created(uri).body(new CommentResponse(comment));
    }

    @Operation(summary = "댓글 삭제", description = "id를 이용하여 댓글을 삭제합니다.")
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @Parameter(hidden = true) @LoginUser SessionUser user,
            @Parameter(description = "기술면접 ID") @PathVariable(name = "interviewId") Long interviewId,
            @Parameter(description = "댓글 ID") @PathVariable(name = "commentId") Long commentId
    ){
        // validate user
        validateUserAuthentication(user);

        // delete comment
        commentService.deleteComment(user.getUserId(), commentId, interviewId);
        return ResponseEntity.noContent().build();
    }

}
