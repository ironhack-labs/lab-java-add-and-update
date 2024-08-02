package com.ironhack.multicityhospital.controller;


import com.ironhack.multicityhospital.model.Employee;
import com.ironhack.multicityhospital.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor


public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }


    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("employeeId") Long employeeId) {

        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping("/{status}")
    public Optional<Employee> getEmployeeByStatus(@PathVariable("status") String status   ){
        return employeeService.getEmployeeByStatus(status);
    }
    @GetMapping("/{department}")
    public Optional<Employee> getEmployeeByDepartment(@PathVariable("department") String department){
        return employeeService.getEmployeeByDepartment(department);
    }
    @PutMapping("/{department}")
    public Employee updateEmployeeByDepartment(@PathVariable("department") String department, @RequestBody Employee employee ){
        return employeeService.updateEmployeeByDepartment(department, employee);
    }

    @PutMapping("/{status}")
    public   Employee updateEmployeeByStatus(@PathVariable("status") String status, @RequestBody Employee employee ){
        return employeeService.updateEmployeeByStatus(status, employee);
    }

}







