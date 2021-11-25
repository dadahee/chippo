package com.j2kb5th.chippo.comment.controller;

import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentParentResponse;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentResponse;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentsResponse;
import com.j2kb5th.chippo.comment.controller.dto.request.CommentRequest;
import com.j2kb5th.chippo.comment.domain.Comment;
import com.j2kb5th.chippo.comment.service.CommentService;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.comment.controller.dto.reponse.CommentUserResponse;
import com.j2kb5th.chippo.user.domain.Provider;
import com.j2kb5th.chippo.user.domain.Role;
import com.j2kb5th.chippo.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/interviews/{interviewId}/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

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
                new CommentParentResponse(null),
                new CommentUserResponse(3L, "참새"),
                "다른 기술면접에 비해 그래도 쉬운편이네요.",
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
        comments.add(new CommentResponse(
                6L,
                new CommentParentResponse(null),
                new CommentUserResponse(4L, "판교꿈나무"),
                "저걸 뚝딱 대답하시다니 대단해요....",
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        comments.add(new CommentResponse(
                7L,
                new CommentParentResponse(null),
                new CommentUserResponse(5L, "니꼴라스동생"),
                "니꼴라스도 울고 가겠어요",
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        return ResponseEntity.ok(new CommentsResponse(comments));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> save(
            @PathVariable(name = "interviewId") Long interviewId,
            @Valid @RequestBody CommentRequest commentRequest
    ){
        //// save comment & get entity to response
        // Comment comment = commentService.save(interviewId, commentRequest);
        //// entity -> response dto & return
        // return ResponseEntity.ok(new CommentResponse(comment));

        User interviewUser = new User(1L, "dev_kid1234@naver.com", "12345678", "개린이", Role.ROLE_USER, Provider.GOOGLE, true, false, null);
        User commentUser = new User(1L, "dobby_wanna_be_free@google.com", "12345678", "n년차도비", Role.ROLE_USER, Provider.NAVER, true, false, null);
        Interview interview = new Interview(interviewId, interviewUser, "VM과 Container 차이에 대해 설명하세요.", "VM은 어려운 것이고 Container도 어려운 것이다.", true, null, null, null);
        Comment comment = new Comment(1L, commentUser, "면접 분위기는 전체적으로 어땠나요?", interview, null, null);
        CommentResponse commentResponse = new CommentResponse(comment);
        return ResponseEntity.ok(commentResponse);
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
