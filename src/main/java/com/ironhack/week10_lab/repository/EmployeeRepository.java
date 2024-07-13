package com.ironhack.week10_lab.repository;

import com.ironhack.week10_lab.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}


