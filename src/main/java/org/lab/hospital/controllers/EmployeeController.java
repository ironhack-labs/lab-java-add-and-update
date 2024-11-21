package org.lab.hospital.controllers;

import org.lab.hospital.entities.Employee;
import org.lab.hospital.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PatchMapping("/{id}/status")
    public Employee updateStatus(@PathVariable Long id, @RequestBody String status) {
        Employee employee = employeeService.findById(id).orElseThrow();
        employee.setStatus(status);
        return employeeService.save(employee);
    }
    @PatchMapping("/{id}/department")
    public Employee updateDepartment(@PathVariable Long id, @RequestBody String department) {
        Employee employee = employeeService.findById(id).orElseThrow();
        employee.setDepartment(department);
        return employeeService.save(employee);
    }

}