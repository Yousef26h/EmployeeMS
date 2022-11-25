package com.example.employeems.adapter.rest.dto;

import com.example.employeems.model.Employee;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class EmployerDTO {
    private String name;

    private String email;

    private List<Employee> employees;
}
