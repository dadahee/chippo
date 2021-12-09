package com.j2kb5th.chippo.tag.controller.dto.response;

import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 임시용
public class TagResponse {
    private final Long id;
    private final String name;

    public TagResponse(Tag tag){
        this.id = tag.getId();
        this.name = tag.getName();
    }
}
