package com.j2kb5th.chippo.user.repository;

import com.j2kb5th.chippo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM USER WHERE id = :id AND deleted <> true")
    Optional<User> findById(@Param("id") Long id);
}
