package com.j2kb5th.chippo.tag.controller;

import com.j2kb5th.chippo.tag.controller.dto.response.TagListResponse;
import com.j2kb5th.chippo.tag.controller.dto.response.TagResponse;
import com.j2kb5th.chippo.tag.domain.Tag;
import com.j2kb5th.chippo.tag.domain.TagType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@io.swagger.v3.oas.annotations.tags.Tag(name = "태그(Tag)", description = "태그 API")
@RequestMapping("/api/tags")
@RequiredArgsConstructor
@RestController
public class TagController {

    @Operation(summary = "태그타입으로 태그 목록 조회",
        description = "홈화면에서 사용 - 기업별/직무별/기술스택별로(타입별로) 태그 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<TagListResponse> findByTagType(
            @Parameter(description = "태그 타입") @RequestParam(name = "type") TagType type
    ){
        List<TagResponse> tags = new ArrayList<>();
        if (type.equals(TagType.TECHSTACK)) {
            tags.add(new TagResponse(1L, "Spring"));
            tags.add(new TagResponse(2L, "TypeScript"));
            tags.add(new TagResponse(3L, "MySQL"));
        } else if (type.equals(TagType.COMPANY)) {
            tags.add(new TagResponse(4L,"카카오"));
            tags.add(new TagResponse(5L,"네이버"));
            tags.add(new TagResponse(6L,"배달의민족"));
        } else if (type.equals(TagType.POSITION)) {
            tags.add(new TagResponse(7L,"프론트엔드"));
            tags.add(new TagResponse(8L,"백엔드"));
        }
        return ResponseEntity.ok(new TagListResponse(type, tags));
    }
}
