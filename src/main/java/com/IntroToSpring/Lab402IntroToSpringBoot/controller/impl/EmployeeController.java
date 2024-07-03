package com.IntroToSpring.Lab402IntroToSpringBoot.controller.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;
import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.EmployeeRepository;
import com.IntroToSpring.Lab402IntroToSpringBoot.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    //    ********************************************* GET *********************************************

    @GetMapping("/employees")
    public List<Employee> getAllDoctors() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getDoctorById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }

    //    ********************************************* POST *********************************************

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
    }

    //    ********************************************* PUT *********************************************

    @PutMapping("/employees/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@PathVariable Long id, @RequestParam String status) {
        employeeService.updateEmployeeStatus(id, status);
    }

    @PutMapping("/employees/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@PathVariable Long id, @RequestParam String department) {
        employeeService.updateEmployeeDepartment(id, department);
    }


}
