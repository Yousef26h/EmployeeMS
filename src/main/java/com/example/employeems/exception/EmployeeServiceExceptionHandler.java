package com.example.employeems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class EmployeeServiceExceptionHandler {
    private final EmployeeServiceExceptionMsgs employeeServiceExceptionMsgs;
    private static final ErrorInfo DEFAULT_ERROR_INFO = new ErrorInfo(-1, 400, new HashMap<>(){{put(Lang.EN, "General Error!");}});

    public EmployeeServiceExceptionHandler(EmployeeServiceExceptionMsgs employeeServiceExceptionMsgs) {
        this.employeeServiceExceptionMsgs = employeeServiceExceptionMsgs;
    }

    @ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<Object> handleEmployeeExceptions(EmployeeServiceException exception) {
        ErrorInfo errorInfo = employeeServiceExceptionMsgs
                .getExceptionMessages()
                .getOrDefault(exception.getClass().getSimpleName(), DEFAULT_ERROR_INFO);
        return new ResponseEntity<>(errorInfo, HttpStatus.valueOf(errorInfo.getStatusCode()));
    }
}
