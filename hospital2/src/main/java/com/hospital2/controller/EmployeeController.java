package com.hospital2.controller;

import com.hospital2.enums.Department;
import com.hospital2.model.Employee;
import com.hospital2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}/status")
    public Employee updateEmployeeStatus(@PathVariable Long id, @RequestParam String status) {
        return employeeService.updateEmployeeStatus(id, status);
    }

    @PutMapping("/{id}/department")
    public Employee updateEmployeeDepartment(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}
