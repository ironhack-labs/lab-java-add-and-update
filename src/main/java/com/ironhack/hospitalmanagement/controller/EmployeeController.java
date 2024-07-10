package com.ironhack.hospitalmanagement.controller;

import com.ironhack.hospitalmanagement.controller.interfaces.IEmployeeController;
import com.ironhack.hospitalmanagement.model.Employee;
import com.ironhack.hospitalmanagement.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return List.of();
    }

    @Override
    public List<Employee> getEmployeesByStatus(String status) {
        return List.of();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}/status")
    public Employee changeEmployeeStatus(@PathVariable Long id, @RequestParam String status) {
        return employeeService.changeEmployeeStatus(id, status);
    }

    @PutMapping("/employees/{id}/department")
    public Employee updateEmployeeDepartment(@PathVariable Long id, @RequestParam String department) {
        return employeeService.updateEmployeeDepartment(id, department);
    }
}
