package com.j2kb5th.chippo.tag.service;

import com.j2kb5th.chippo.tag.repository.InterviewTagRepository;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;
    private final InterviewTagRepository interviewTagRepository;
}
