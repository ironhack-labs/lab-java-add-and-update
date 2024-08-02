package com.ironhack.multicityhospital.repository;

import com.ironhack.multicityhospital.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByStatus(String status);
    Optional<Employee> findByDepartment(String department);
}
