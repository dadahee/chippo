package com.j2kb5th.chippo.thumb.repository;

import com.j2kb5th.chippo.thumb.domain.Thumb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThumbRepository extends JpaRepository<Thumb, Long> {
}
