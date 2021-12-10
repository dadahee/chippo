package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.tag.domain.TagType;

import java.util.List;

public interface InterviewService {
    Interview findInterviewById(Long interviewId);
    List<Interview> findInterviewsByTag(String tagName, TagType tagType, Long size);
}
