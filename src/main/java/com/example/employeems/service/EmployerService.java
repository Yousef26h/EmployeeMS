package com.example.employeems.service;

import com.example.employeems.adapter.rest.dto.EmployerDTO;

import java.util.List;
import java.util.Optional;

public interface EmployerService {
    void addEmployer(EmployerDTO employerDTO);

    List<EmployerDTO> getAllEmployers();

    Optional<EmployerDTO> getById();

    EmployerDTO updateEmployer(Long id);
}
