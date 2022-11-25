package com.example.employeems.exception;

public class EmployeeNotFoundException extends EmployeeServiceException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
