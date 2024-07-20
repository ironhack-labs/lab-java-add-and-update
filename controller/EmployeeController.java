package com.ironhack.week10lab.controller;

import com.ironhack.week10lab.model.Employee;
import com.ironhack.week10lab.model.EmployeeStatus;
import com.ironhack.week10lab.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PatchMapping("/{employeeId}/status")
    public Employee updateEmployeeStatus(@PathVariable Integer employeeId, @RequestParam EmployeeStatus status) {
        return employeeService.updateEmployeeStatus(employeeId, status);
    }

    @PatchMapping("/{employeeId}/department")
    public Employee updateEmployeeDepartment(@PathVariable Integer employeeId, @RequestParam String department) {
        return employeeService.updateEmployeeDepartment(employeeId, department);
    }
}
