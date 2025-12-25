package com.vax.spring_security_demo.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record ErrorResponse(int httpCode, String message, long timestamp) {

    public static ErrorResponse produce(int httpCode, String message) {
        return new ErrorResponse(httpCode, message, System.currentTimeMillis());
    }
}
