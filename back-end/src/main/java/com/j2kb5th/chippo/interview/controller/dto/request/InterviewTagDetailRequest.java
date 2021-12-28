package com.j2kb5th.chippo.interview.controller.dto.request;

import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class InterviewTagDetailRequest {

    @NotNull
    private TagType type;

    @Size(max = 20)
    @NotNull
    private String name;

    public Tag toEntity() {
        return Tag.builder()
                .type(type)
                .name(name)
                .build();
    }
}
