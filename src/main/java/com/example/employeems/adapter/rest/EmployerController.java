package com.example.employeems.adapter.rest;

import com.example.employeems.adapter.rest.dto.EmployerDTO;
import com.example.employeems.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    public final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployer(EmployerDTO employerDTO) {
        employerService.addEmployer(employerDTO);
    }


}
