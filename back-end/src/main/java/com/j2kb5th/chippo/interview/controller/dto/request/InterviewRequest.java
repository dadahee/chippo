package com.j2kb5th.chippo.interview.controller.dto.request;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Getter
public class InterviewRequest {

    @NotNull
    private Long userId;

    @Size(max = 150)
    @NotNull
    private String question;

    @Size(max = 300)
    @NotNull
    private String answer;

    @Size(max = 300)
    private String extraInfo;

    private List<InterviewTagDetailRequest> interviewTags;

    public Interview toEntity(User user){
        return Interview.builder()
                .user(user)
                .question(question)
                .answer(answer)
                .extraInfo(extraInfo)
                .build();
    }
}
