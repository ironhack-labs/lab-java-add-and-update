package com.example.demo.controllers;

import com.example.demo.DTOs.EmployeeDTO;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployees(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        Employee existEmployee = employeeRepository.findById(id).orElse(null);

        if (existEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (employeeDTO.getStatus() != null) {
            existEmployee.setStatus(employeeDTO.getStatus());
            employeeRepository.save(existEmployee);
        }

        if (employeeDTO.getDepartment() != null) {
            existEmployee.setDepartment(employeeDTO.getDepartment());
            employeeRepository.save(existEmployee);
        }
    }

}
