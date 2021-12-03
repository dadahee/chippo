package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.thumb.domain.Thumb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor // 임시
@Getter
public class InterviewThumbResponse {

    @NotNull
    private final boolean clicked;

    @NotNull
    private final Long count;
}
