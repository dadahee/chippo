package com.j2kb5th.chippo.admin.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class AdminThumbResponse {
    private final Long id;

    private final Long interviewId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;

    public AdminThumbResponse(Thumb thumb){
        this.id = thumb.getId();
        this.interviewId = thumb.getInterview().getId(); // 처리 필요
        this.createdAt = thumb.getCreatedAt();
    }
}
