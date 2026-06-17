package com.luv2code.employeemanagement.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //so now making it run globally
public class EmployeeErrorHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleNotFoundErr(EmployeeNotFoundException exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        //set the err props
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage()); //use message from to err
        errorResponse.setTimeStamp(System.currentTimeMillis());

        //return the error as response body nd set the response status
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    //bad request exc handler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleConflictException(EmployeeConflictException exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        //set the err props
        errorResponse.setStatusCode(HttpStatus.CONFLICT.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        //return the error as response body nd set the response status
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

    }

    //other err handler
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleOtherErrs(Exception exc){
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        //set the err props
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        //return the error as response body nd set the response status
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
