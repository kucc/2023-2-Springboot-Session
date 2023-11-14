package com.example.week6.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "user not found"),
    WRONG_USER_TYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "wrong user type"),
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "team not found");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
