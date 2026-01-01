package com.example.delivery_service.exception;

import com.example.delivery_service.constant.ErrorConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DeliveryNotFound.class)
    public ResponseEntity<ErrorMessage> handleDeliveryNotFound(DeliveryNotFound exception) {
        ErrorMessage errorMessage= ErrorMessage.builder()
                .message(ErrorConstant.DELIVERY_NOT_FOUND)
                .httpStatusCode(HttpStatusCode.valueOf(404))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }
}
