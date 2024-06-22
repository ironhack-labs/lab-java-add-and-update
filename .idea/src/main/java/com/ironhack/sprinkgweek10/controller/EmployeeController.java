package com.ironhack.sprinkgweek10.controller;

import com.ironhack.sprinkgweek10.model.Employee;
import com.ironhack.sprinkgweek10.model.Status;
import com.ironhack.sprinkgweek10.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
    @PatchMapping("/{id}")
    public Employee updatesStatus(@PathVariable("id") int id, @RequestBody Status status) {
        return employeeService.updateStatus(id,status);
    }
    @PatchMapping("/{id}")
    public Employee updateDepartment(@PathVariable("id") int id, @RequestBody String department) {
        return employeeService.updateDepartment(id,department);
    }
}
