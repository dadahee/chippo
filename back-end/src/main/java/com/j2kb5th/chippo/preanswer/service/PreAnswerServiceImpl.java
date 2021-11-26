package com.j2kb5th.chippo.preanswer.service;

import com.j2kb5th.chippo.preanswer.repository.PreAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PreAnswerServiceImpl implements PreAnswerService {

    private final PreAnswerRepository preAnswerRepository;
}
