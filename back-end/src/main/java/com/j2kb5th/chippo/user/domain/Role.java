package com.j2kb5th.chippo.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    GUEST("ROLE_GUEST", "미인증 사용자"),
    USER("ROLE_USER", "인증된 사용자"),
    ADMIN("ROLE_ADMIN", "관리자"),
    BLOCKED("ROLE_BLOCKED", "차단된 사용자");

    private final String key;
    private final String title;

}
