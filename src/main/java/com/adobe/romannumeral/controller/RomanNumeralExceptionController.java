package com.adobe.romannumeral.controller;

import com.adobe.romannumeral.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RomanNumeralExceptionController {

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Object> exception(InvalidInputException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
