package com.example.security_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorMessage userAlreadyExistsException(UserAlreadyExistsException e) {
        return ErrorMessage.builder()
                .message("User already exists try to login.")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorMessage usernameNotFoundException(UsernameNotFoundException e) {
        return ErrorMessage.builder()
                .message("Username not found.")
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }
}
