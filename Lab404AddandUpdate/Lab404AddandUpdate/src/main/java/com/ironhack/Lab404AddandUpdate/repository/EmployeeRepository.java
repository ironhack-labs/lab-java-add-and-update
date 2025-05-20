package com.ironhack.Lab404AddandUpdate.repository;

import com.ironhack.Lab404AddandUpdate.model.Employee;
import com.ironhack.Lab404AddandUpdate.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // here custom methods if I need them

    List<Employee> findAllByStatus(EmployeeStatus status);

    List<Employee> findAllByDepartment(String department);




}
