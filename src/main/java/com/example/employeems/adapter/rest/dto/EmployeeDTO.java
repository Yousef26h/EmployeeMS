package com.example.employeems.adapter.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    private String firstName;

    private String lastName;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private double baseSalary;

}
