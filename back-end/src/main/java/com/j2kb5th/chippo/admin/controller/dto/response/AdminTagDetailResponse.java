package com.j2kb5th.chippo.admin.controller.dto.response;

import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 테스트용
@Getter
public class AdminTagDetailResponse {
    private final Long id;
    private final TagType type;
    private final String name;

    public AdminTagDetailResponse(Tag tag){
        this.id = tag.getId();
        this.type = tag.getType();
        this.name = tag.getName();
    }
}
