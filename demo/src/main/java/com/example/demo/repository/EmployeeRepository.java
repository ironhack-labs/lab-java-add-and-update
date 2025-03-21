package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    List<Employee> findByDepartment(String department);
}

