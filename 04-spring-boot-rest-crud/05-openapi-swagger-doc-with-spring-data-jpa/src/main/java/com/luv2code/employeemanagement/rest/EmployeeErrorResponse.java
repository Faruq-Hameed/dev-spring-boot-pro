package com.luv2code.employeemanagement.rest;

public class EmployeeErrorResponse {
    private int StatusCode;
    private String message;
    private Long timeStamp;

    //define constructors
    public EmployeeErrorResponse(){}
    public EmployeeErrorResponse(int statusCode, String message, Long timeStamp) {
        StatusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
