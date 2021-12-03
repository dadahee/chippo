package com.j2kb5th.chippo.thumb.controller.dto.response;

import com.j2kb5th.chippo.thumb.domain.Thumb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckThumbResponse {

    private final boolean thumbsUp;
    private final ThumbResponse thumb;

    public CheckThumbResponse(boolean thumbsUp, Thumb thumb) {
        this.thumbsUp = thumbsUp;
        this.thumb = new ThumbResponse(thumb);
    }
}
