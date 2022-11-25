package com.example.employeems.service;

import com.example.employeems.adapter.rest.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findById(Long id);

    void addEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
