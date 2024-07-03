package com.IntroToSpring.Lab402IntroToSpringBoot.service.interfaces;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getEmployeesByStatus(String status);

    List<Employee> getEmployeesByDepartment(String department);

    void saveEmployee(Employee employee);

    void updateEmployeeStatus(Long id, String status);

    void updateEmployeeDepartment(Long id, String department);
}
