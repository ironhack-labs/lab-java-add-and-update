package com.ironhack.week10_lab.controller;

import com.ironhack.week10_lab.model.Employee;
import com.ironhack.week10_lab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateEmployeeStatus(@PathVariable Integer id, @RequestParam String status) {
        Employee updatedEmployee = employeeService.updateEmployeeStatus(id, status);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/department")
    public ResponseEntity<Employee> updateEmployeeDepartment(@PathVariable Integer id, @RequestParam String department) {
        Employee updatedEmployee = employeeService.updateEmployeeDepartment(id, department);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


