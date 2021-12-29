package com.j2kb5th.chippo.interview.controller.dto.request;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
public class SaveInterviewRequest extends InterviewRequest {

    private List<SaveInterviewTagDetailRequest> interviewTags;
}
