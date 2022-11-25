package com.example.employeems.service.impl;

import com.example.employeems.adapter.repository.EmployeeRepository;
import com.example.employeems.adapter.rest.dto.EmployeeDTO;
import com.example.employeems.exception.EmployeeNotFoundException;
import com.example.employeems.model.Employee;
import com.example.employeems.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .filter(Employee::isActive)
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .filter(Employee::isActive)
                .orElseThrow(() -> new EmployeeNotFoundException("No Employee with such id: " + id));
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));
    }

    @Override
    @Transactional
    public void updateEmployee(Long id, EmployeeDTO employeeDTO) {
        employeeRepository.createTestTable();
        employeeRepository.updateEmployee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail(), employeeDTO.getBirthDate(), employeeDTO.getBaseSalary(), id);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
