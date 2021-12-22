package com.j2kb5th.chippo.global.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    /**
     * GL### : Global Error
     */
    GL001("유저 정보를 찾을 수 없습니다."),
    GL002("인터뷰 정보를 찾을 수 없습니다."),
    GL003("로그인이 필요합니다."),
    GL004("권한이 없습니다."),


    /**
     * AD### : Admin Error
     */
    AD001("에러 메시지 내용을 작성"),


    /**
     * CO### : Comment Error
     */

    /**
     * IN### : Interview Error
     */
    IN001("인터뷰 정보를 찾을 수 없습니다."),


    /**
     * PR### : PreAnswer Error
     */

    /**
     * TA### : Tag Error
     */
    TA001("기술스택 태그를 1개 이상 작성해야 합니다."),
    TA002("태그는 타입별로 3개까지 작성 가능합니다."),
    TA003("태그를 1개 이상 작성해야 합니다."),
    TA004("태그명과 타입에 일치하는 태그가 없습니다."),
    TA005("태그를 찾을 수 없습니다."),

    /**
     * TH### : Thumb Error
     */

    /**
     * US### : User Error
     */

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
