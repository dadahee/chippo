package com.j2kb5th.chippo.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

@Getter
public class GlobalException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public GlobalException(HttpStatus status, ErrorMessage error) {
        this.status = status;
        this.message = error.getMessage();
    }
}
