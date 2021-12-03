package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InterviewServiceImpl implements InterviewService {
    private final InterviewRepository interviewRepository;
}
