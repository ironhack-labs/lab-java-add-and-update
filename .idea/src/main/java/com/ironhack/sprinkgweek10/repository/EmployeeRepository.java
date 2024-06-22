package com.ironhack.sprinkgweek10.repository;

import com.ironhack.sprinkgweek10.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
