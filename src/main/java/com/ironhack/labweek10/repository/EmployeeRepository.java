package com.ironhack.labweek10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository<Employee> extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);

    List<Employee> findByDepartment(String department);
}

