package com.j2kb5th.chippo.user.domain;

import com.j2kb5th.chippo.global.domain.BaseTimeEntity;
import com.j2kb5th.chippo.thumb.domain.Thumb;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String nickname;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 40)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider provider;

    @ColumnDefault("0")
    @Column(nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Thumb> thumbs = new ArrayList<>();

    @Builder
    public User(String email, String password, String nickname, Role role, Provider provider) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.provider = provider;
    }

    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public void delete() {
        this.deleted = true;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    /**
     * 관리자 여부 리턴
     * @return 관리자인 경우 true, 아닐 경우 false
     */
    public boolean isAdmin() {
        return (this.role.equals(Role.ADMIN));
    }

    /**
     * 활동 권한이 있는 일반 유저인지 체크
     * @return 일반 사용자이고 삭제되지 않았을 경우 true, 아닐 경우 false(관리자도 false)
     */
    public boolean isActive() {
        // 일반 사용자 && 삭제되지 않음
        return (this.role.equals(Role.USER) && (!this.deleted));
    }

    /**
     * 동일 유저인지 체크
     * @param id(request dto 등에서 추출한 user id)
     * @return 해당 유저 id와 user 객체의 id가 일치하면 true
     */
    public boolean isSameUserWith(Long id){
        return this.id == id;
    }

    /**
     * 등록/수정/삭제 권한이 있는지 판단
     * @param id(일치여부를 검사할 user id)
     * @return 관리자이거나 활성유저인 동시에 요청한 id와 user 객체의 id가 일치하면 true, 아니면 false
     */
    public boolean hasAuthority(Long id) {
        return (isActive() && isSameUserWith(id)) || isAdmin();
    }
}
