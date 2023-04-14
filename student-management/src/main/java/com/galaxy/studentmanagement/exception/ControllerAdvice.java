package com.galaxy.studentmanagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<APIException> handleNotFoundException(NotFoundException ex) {
        log.warn(ex.getMessage());
        APIException APIException = new APIException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(APIException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<APIException> handleValidationException(ValidationException ex){
        log.warn(ex.getMessage());
        APIException APIException =  new APIException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(APIException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIException> handleConstraintViolationException(ConstraintViolationException ex){
        log.warn(ex.getMessage());
        APIException APIException =  new APIException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(APIException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIException> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        log.warn(ex.getMessage());
        Set<String> errors = new HashSet<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        String messages = String.join(" - ", errors);
        APIException APIException =  new APIException(HttpStatus.BAD_REQUEST.value(),messages);
        return new ResponseEntity<>(APIException,HttpStatus.BAD_REQUEST);
    }

}