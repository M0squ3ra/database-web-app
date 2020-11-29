package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException customerNotFoundException){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),customerNotFoundException.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<CustomerErrorResponse>(customerErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception){

        CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<CustomerErrorResponse>(customerErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
