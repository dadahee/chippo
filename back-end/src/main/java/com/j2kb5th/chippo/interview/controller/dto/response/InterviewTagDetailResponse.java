package com.j2kb5th.chippo.interview.controller.dto.response;

import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;


@Getter
public class InterviewTagDetailResponse {
    private final Long id;
    private final TagType type;
    private final String name;

    public InterviewTagDetailResponse(Tag tag){
        this.id = tag.getId();
        this.type = tag.getType();
        this.name = tag.getName();
    }
}
