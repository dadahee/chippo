package com.j2kb5th.chippo.user.repository;

import com.j2kb5th.chippo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE id = :id AND deleted <> true")
    Optional<User> findById(@Param("id") Long id);

    Optional<User> findByNickname(String nickname); // 탈퇴한 회원의 닉네임도 중복 사용 불가
}
