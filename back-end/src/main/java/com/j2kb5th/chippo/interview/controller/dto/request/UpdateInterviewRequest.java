package com.j2kb5th.chippo.interview.controller.dto.request;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor // 접근제한 추가 필요
@Getter
public class UpdateInterviewRequest extends InterviewRequest {

    private Long id;

    private List<UpdateInterviewTagDetailRequest> interviewTags;
}
