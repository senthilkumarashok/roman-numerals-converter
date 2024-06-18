package com.adobe.romannumeral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Invalid Input")  // 404
public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {

    }
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(String message) {
        super(message);
    }
    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
