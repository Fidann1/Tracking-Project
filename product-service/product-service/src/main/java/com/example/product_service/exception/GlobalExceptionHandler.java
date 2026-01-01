package com.example.product_service.exception;

import com.example.product_service.constant.ErrorConstant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductDoesNotExist.class)
    public ErrorMessage productDoesNotExist() {
        return ErrorMessage.builder()
                .message(ErrorConstant.PRODUCT_DOES_NOT_EXIST)
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
