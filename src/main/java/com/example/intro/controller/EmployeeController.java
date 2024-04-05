package com.example.intro.controller;

import com.example.intro.model.Employee;
import com.example.intro.dtos.EmployeeDTO;
import com.example.intro.model.utils.Status;
import com.example.intro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/byDepartment/{department}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "department") String department) {
        return employeeService.findByDepartment(department);
    }

    @GetMapping("/employees/byStatus/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "status") Status status) {
        return employeeService.findByStatus(status);
    }
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(name = "id") int employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PatchMapping("/employees/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void patchEmployee(@PathVariable(name = "id") int id, @RequestBody EmployeeDTO partialEmployee) {
        if (partialEmployee.getStatus()!= null) {
            employeeService.updateStatus(id, partialEmployee.getStatus());
        }
        if (partialEmployee.getDepartment() != null) {
            employeeService.updateDepartment(id, partialEmployee.getDepartment());
        }
    }
}
