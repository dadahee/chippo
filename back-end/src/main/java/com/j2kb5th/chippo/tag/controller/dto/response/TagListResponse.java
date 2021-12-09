package com.j2kb5th.chippo.tag.controller.dto.response;

import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor // 설계용 임시
public class TagListResponse {
    private final TagType type;
    private final List<TagResponse> tags;

    public TagListResponse(List<Tag> tags) {
        if (tags.isEmpty()) {
            // 처리
        }
        this.type = tags.get(0).getType();
        this.tags = tags.stream().map(TagResponse::new).collect(Collectors.toList());
    }
}
