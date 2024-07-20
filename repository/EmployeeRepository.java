package com.ironhack.week10lab.repository;

import com.ironhack.week10lab.model.Employee;
import com.ironhack.week10lab.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee>findByDepartment(String department );
}
