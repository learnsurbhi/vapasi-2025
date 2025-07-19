package com.tw.rest;

import com.tw.util.InvalidTicketException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TicketExceptionHandler {

    @ExceptionHandler(InvalidTicketException.class)
    public ResponseEntity<?> handleInvalidTicketException(InvalidTicketException exception){
        ErrorResponse error = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST,"Invalid Code");
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}

