package com.labs.lab_add_and_update.repository;

import com.labs.lab_add_and_update.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
