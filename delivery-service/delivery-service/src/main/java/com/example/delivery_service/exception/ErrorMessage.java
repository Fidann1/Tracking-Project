package com.example.delivery_service.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
public class ErrorMessage {

    private String message;
    private HttpStatusCode httpStatusCode;

}
