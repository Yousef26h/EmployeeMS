package com.example.employeems.adapter.repository;

import com.example.employeems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



    @Modifying(clearAutomatically = true) //to clear persistence context to make sure to fetch data from database next time
    @Query(
            value = "UPDATE employee e SET first_name=?1, last_name=?2, email=?3, birth_date=?4, base_salary=?5 WHERE e.id=?6 AND e.is_active=true",
            nativeQuery = true
    )
    void updateEmployee(String firstName, String lastName, String email, LocalDate birthDate, double baseSalary, Long id);


    @Modifying
    @Query(
            value = "CREATE TABLE test_table(name varchar)",
            nativeQuery = true
    )
    void createTestTable();

    @Modifying
    @Query(
            value = "UPDATE employee e SET is_active=false WHERE e.id=?1",
            nativeQuery = true
    )
    void deleteById(Long id);
}
