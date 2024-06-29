package com.ironhack.springboot.repository;

import com.ironhack.springboot.enums.EmployeeStatus;
import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    Add new doctor: Create a route to add a new doctor.
    Employee addEmployee(Employee employee);
}
