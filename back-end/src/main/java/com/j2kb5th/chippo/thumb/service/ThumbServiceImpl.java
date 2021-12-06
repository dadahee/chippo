package com.j2kb5th.chippo.thumb.service;

import com.j2kb5th.chippo.thumb.repository.ThumbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThumbServiceImpl implements ThumbService {
    private final ThumbRepository thumbRepository;
}
