package com.j2kb5th.chippo.thumb.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // 더미데이터용 (추후 삭제)
public class ThumbResponse {

    private final Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;

    public ThumbResponse(Thumb thumb) {
        this.id = thumb.getId();
        this.createdAt = thumb.getCreatedAt();
    }
}
