package com.example.security_service.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorMessage {
    private String message;
    private HttpStatus httpStatus;
}
