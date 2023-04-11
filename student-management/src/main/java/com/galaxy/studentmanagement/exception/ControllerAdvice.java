package com.galaxy.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIException> handleNotFoundException(NotFoundException ex) {
        APIException APIException = new APIException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(APIException, HttpStatus.NOT_FOUND);
    }
}