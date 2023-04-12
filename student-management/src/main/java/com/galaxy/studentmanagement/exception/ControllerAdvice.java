package com.galaxy.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIException> handleNotFoundException(NotFoundException ex) {
        APIException APIException = new APIException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(APIException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<APIException> handleValidationException(ValidationException ex){
        APIException APIException =  new APIException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(APIException,HttpStatus.BAD_REQUEST);
    }

}