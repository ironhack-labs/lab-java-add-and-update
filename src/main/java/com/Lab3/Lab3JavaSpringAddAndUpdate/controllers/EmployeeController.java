package com.Lab3.Lab3JavaSpringAddAndUpdate.controllers;

import com.Lab3.Lab3JavaSpringAddAndUpdate.dto.EmployeeDTO;
import com.Lab3.Lab3JavaSpringAddAndUpdate.enums.EmployeeStatus;
import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Lab3.Lab3JavaSpringAddAndUpdate.services.EmployeeService;


import java.util.Optional;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //add doctor
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){ return employeeService.createEmployee(employee);}


    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //change status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateEmployeeStatus(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
        Optional<Employee> employeeOptional = employeeService.updateEmployeeStatus(id, employee);
        return employeeOptional.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    //update department employee
    @PatchMapping("/{id}/department")
    public ResponseEntity<Employee> updateEmployeeDepartment(@PathVariable Long id, @RequestBody EmployeeDTO department){
        Optional<Employee> updateEmployee = employeeService.updateEmployeeDepartment(id, department);
        return updateEmployee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
