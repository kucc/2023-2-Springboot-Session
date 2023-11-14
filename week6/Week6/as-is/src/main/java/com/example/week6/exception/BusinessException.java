package com.example.week6.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorStatus() {
        return errorCode.getStatus();
    }

    public String getMessage() {
        return errorCode.getMessage();
    }
}
