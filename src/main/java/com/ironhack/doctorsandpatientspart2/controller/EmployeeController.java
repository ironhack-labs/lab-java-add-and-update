package com.ironhack.doctorsandpatientspart2.controller;

import com.ironhack.doctorsandpatientspart2.enums.Status;
import com.ironhack.doctorsandpatientspart2.model.Employee;
import com.ironhack.doctorsandpatientspart2.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
    @PatchMapping("/{id}")
    public Employee updateStatus(@PathVariable("id") Integer id, @RequestBody Status status) {
        return employeeService.updateStatus(id,status);
    }
    @PatchMapping("/id/{id}")
    public Employee updateDepartment(@PathVariable("id") Integer id, @RequestBody String department) {
        return employeeService.updateDepartment(id,department);
    }
}
