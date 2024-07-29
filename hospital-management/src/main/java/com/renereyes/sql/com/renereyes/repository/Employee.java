package com.renereyes.hospital.repository;

import com.renereyes.hospital.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
