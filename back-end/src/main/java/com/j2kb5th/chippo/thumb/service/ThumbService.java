package com.j2kb5th.chippo.thumb.service;

import com.j2kb5th.chippo.thumb.domain.Thumb;

public interface ThumbService {

    Thumb saveThumb(Long interviewId, Long userId);

    void cancelThumb(Long interviewId, Long userId);
}
