package com.example.employeems.service.impl;

import com.example.employeems.adapter.repository.EmployerRepository;
import com.example.employeems.adapter.rest.dto.EmployerDTO;
import com.example.employeems.model.Employer;
import com.example.employeems.service.EmployerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    public final EmployerRepository employerRepository;
    public final ModelMapper modelMapper;

    public EmployerServiceImpl(EmployerRepository employerRepository, ModelMapper modelMapper) {
        this.employerRepository = employerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addEmployer(EmployerDTO employerDTO) {
        Employer employer = modelMapper.map(employerDTO, Employer.class);
        employerRepository.save(employer);
    }

    @Override
    public List<EmployerDTO> getAllEmployers() {
        return null;
    }

    @Override
    public Optional<EmployerDTO> getById() {
        return Optional.empty();
    }

    @Override
    public EmployerDTO updateEmployer(Long id) {
        return null;
    }
}
