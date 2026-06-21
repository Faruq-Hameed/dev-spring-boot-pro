package com.luv2code.employeemanagement.rest;

public class EmployeeConflictException extends RuntimeException {
    public EmployeeConflictException() {
    }

    public EmployeeConflictException(String message) {
        super(message);
    }

    public EmployeeConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeConflictException(Throwable cause) {
        super(cause);
    }
}
