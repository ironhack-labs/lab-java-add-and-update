package com.ironhack.hospitalmanagement.service.interfaces;

import com.ironhack.hospitalmanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long id);
    Employee addEmployee(Employee employee);
    Employee changeEmployeeStatus(Long id, String status);
    Employee updateEmployeeDepartment(Long id, String department);
}
