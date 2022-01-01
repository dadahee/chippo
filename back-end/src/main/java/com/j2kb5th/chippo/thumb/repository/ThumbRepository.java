package com.j2kb5th.chippo.thumb.repository;

import com.j2kb5th.chippo.thumb.domain.Thumb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ThumbRepository extends JpaRepository<Thumb, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM thumb WHERE interview_id = :interview_id AND user_id = :user_id")
    Optional<Thumb> findByInterviewAndUser(@Param("interview_id") Long interviewId, @Param("user_id") Long userId);
}
