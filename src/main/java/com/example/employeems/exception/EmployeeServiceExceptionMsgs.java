package com.example.employeems.exception;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "com.employee.errors")
@Component
@Data
public class EmployeeServiceExceptionMsgs {
    private Map<String, ErrorInfo> exceptionMessages;
}
