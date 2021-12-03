package com.j2kb5th.chippo.tag.repository;

import com.j2kb5th.chippo.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
