package com.j2kb5th.chippo.preanswer.repository;

import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PreAnswerRepository extends JpaRepository<PreAnswer, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM pre_answer WHERE user_id = :user_id AND interview_id = :interview_id")
    Optional<PreAnswer> findByIdAndUserId(@Param("interview_id") Long interviewId, @Param("user_id") Long userId);
}
