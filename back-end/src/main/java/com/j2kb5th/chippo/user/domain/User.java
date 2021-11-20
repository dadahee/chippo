package com.j2kb5th.chippo.user.domain;

import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.like.domain.Like;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider provider;

    @ColumnDefault("1")
    @Column(nullable = false)
    private boolean activated;

    @ColumnDefault("0")
    @Column(nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();
}
