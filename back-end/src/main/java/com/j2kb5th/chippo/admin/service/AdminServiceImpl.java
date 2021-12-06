package com.j2kb5th.chippo.admin.service;

import com.j2kb5th.chippo.comment.repository.CommentRepository;
import com.j2kb5th.chippo.interview.repository.InterviewRepository;
import com.j2kb5th.chippo.preanswer.repository.PreAnswerRepository;
import com.j2kb5th.chippo.tag.repository.TagRepository;
import com.j2kb5th.chippo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;
    private final PreAnswerRepository preAnswerRepository;
}
