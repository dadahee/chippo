package com.j2kb5th.chippo.comment.controller;

import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentResponse;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentsResponse;
import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.comment.service.CommentServiceImpl;
import com.j2kb5th.chippo.global.controller.dto.UserResponse;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
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
@RequestMapping("/api/interviews/{interviewId}/comments")
@RestController
public class CommentController {

    private final CommentServiceImpl commentService;

    // 페이지네이션 구현할 때만 필요
    @GetMapping
    public ResponseEntity<CommentsResponse> find(
        @PathVariable(name = "interviewId") Long interviewId
    ){
        //// find comments by interview id
        // commentService.findByInterviewId(interviewId);
        //// entity -> response dto & return
        // return ResponseEntity.ok(new CommentsResponse());
        List<CommentResponse> comments = new ArrayList<>();
        comments.add(new CommentResponse(
                5L,
                null,
                new UserResponse(3L, "고인물"),
                "다른 기술면접에 비해 그래도 쉬운편이네요.",
                LocalDateTime.now()
        ));

        comments.add(new CommentResponse(
                6L,
                null,
                new UserResponse(4L, "고인물"),
                "저걸 뚝딱 대답하시다니 대단해요....",
                LocalDateTime.now()
        ));

        comments.add(new CommentResponse(
                7L,
                6L,
                new UserResponse(5L, "니꼴라스동생"),
                "그러니까요. 니꼴라스도 울고 가겠어요",
                LocalDateTime.now()
        ));
        return ResponseEntity.ok(new CommentsResponse(comments));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> save(
            UriComponentsBuilder uriBuilder,
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody CommentRequest commentRequest
    ){
        //// save comment & get entity to response
        // Comment comment = commentService.save(interviewId, commentRequest);
        //// entity -> response dto & return
        // return ResponseEntity.ok(new CommentResponse(comment));

        CommentResponse commentResponse = new CommentResponse(1L, null, new UserResponse(123L, "n년차 도비"), "면접 분위기는 어땠나요?", LocalDateTime.now());

        URI uri = uriBuilder.path("/api/interviews/{interviewId}/comments").buildAndExpand(interviewId).toUri();
        return ResponseEntity.created(uri).body(commentResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @PathVariable(name = "interviewId") Long interviewId,
            @PathVariable(name = "commentId") Long commentId
    ){
        //// delete comment
        // commentService.delete(interviewId, commentId);
        return ResponseEntity.noContent().build();
    }
}
