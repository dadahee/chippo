package com.j2kb5th.chippo.interview.controller.dto.request;

import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor // 접근 제한 추가 필요
public class UpdateInterviewTagDetailRequest {

    @NotNull
    private Long id;

    @NotNull
    private TagType type;

    @Size(max = 20)
    @NotNull
    private String name;
}
