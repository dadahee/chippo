package com.j2kb5th.chippo.interview.repository;

import com.j2kb5th.chippo.interview.domain.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
