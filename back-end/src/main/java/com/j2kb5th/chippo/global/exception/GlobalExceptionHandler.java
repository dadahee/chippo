package com.j2kb5th.chippo.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(GlobalException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(new ErrorResponse(exception.getMessage()));
    }
}
