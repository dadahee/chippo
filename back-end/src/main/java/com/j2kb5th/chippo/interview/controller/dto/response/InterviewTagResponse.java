package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.tag.domain.InterviewTag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor // 임시 어노테이션
public class InterviewTagResponse {
    private final Long id;
    private final InterviewTagDetailResponse tag;

    public InterviewTagResponse(InterviewTag interviewTag){
        this.id = interviewTag.getId();
        this.tag = new InterviewTagDetailResponse(interviewTag.getTag());
    }
}
