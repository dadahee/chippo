package com.j2kb5th.chippo.preanswer.repository;

import com.j2kb5th.chippo.preanswer.domain.PreAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreAnswerRepository extends JpaRepository<PreAnswer, Long> {
}
