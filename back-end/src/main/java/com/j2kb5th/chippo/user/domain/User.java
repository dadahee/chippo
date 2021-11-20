package com.j2kb5th.chippo.user.domain;

import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 40)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String provider;

    @Column(nullable = false)
    private boolean activated = true;

    @Column(nullable = false)
    private boolean deleted = false;

}
