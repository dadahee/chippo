package com.j2kb5th.chippo.global.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    /**
     * GL### : Global Error
     */
    GL001("유저 정보를 찾을 수 없습니다."),
    GL002("인터뷰 정보를 찾을 수 없습니다."),


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
    IN001("interview"),

    /**
     * PR### : PreAnswer Error
     */

    /**
     * TA### : Tag Error
     */

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
