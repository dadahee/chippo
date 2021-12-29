package com.j2kb5th.chippo.interview.service;

import com.j2kb5th.chippo.interview.controller.dto.request.SaveInterviewRequest;
import com.j2kb5th.chippo.interview.controller.dto.request.UpdateInterviewRequest;
import com.j2kb5th.chippo.interview.domain.Interview;
import com.j2kb5th.chippo.tag.domain.TagType;

import java.util.List;

public interface InterviewService {
    Interview findInterviewById(Long interviewId);
    List<Interview> findInterviewsByTag(String tagName, TagType tagType, Long size) throws Exception;

    Interview saveInterview(SaveInterviewRequest interviewRequest, Long userId);
    Interview updateInterview(UpdateInterviewRequest interviewRequest, Long userId);
    void deleteInterview(Long interviewId, Long userId);
}
