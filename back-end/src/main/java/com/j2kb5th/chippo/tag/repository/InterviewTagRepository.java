package com.j2kb5th.chippo.tag.repository;

import com.j2kb5th.chippo.tag.domain.InterviewTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewTagRepository extends JpaRepository<InterviewTag, Long> {
    List<InterviewTag> findByTagId(Long id);
    List<InterviewTag> findByInterviewId(Long id);

    Long countByTagId(Long id);
}
