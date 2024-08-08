package com.ironhack.week_10_lab.controller;


import com.ironhack.week_10_lab.model.Employee;
import com.ironhack.week_10_lab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateStatus(@PathVariable int id, @RequestBody Map<String, String> status) {
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setStatus(Employee.Status.valueOf(status.get("status")));
        employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PatchMapping("/{id}/department")
    public ResponseEntity<Employee> updateDepartment(@PathVariable int id, @RequestBody Map<String, String> department) {
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDepartment(department.get("department"));
        employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }
}

