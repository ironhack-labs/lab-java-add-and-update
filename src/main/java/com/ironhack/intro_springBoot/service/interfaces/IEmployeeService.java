package com.ironhack.intro_springBoot.service.interfaces;

import com.ironhack.intro_springBoot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    List<Employee> getEmployeeByStatus(String status);

    List<Employee> getEmployeesByDepartment(String department);
}
