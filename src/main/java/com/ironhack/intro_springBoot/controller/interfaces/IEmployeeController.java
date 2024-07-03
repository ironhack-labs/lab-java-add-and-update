package com.ironhack.intro_springBoot.controller.interfaces;

import com.ironhack.intro_springBoot.model.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeController {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public List<Employee> getEmployeesByDepartment(String department);
    public List<Employee> getEmployeesByStatus(String status);
}
