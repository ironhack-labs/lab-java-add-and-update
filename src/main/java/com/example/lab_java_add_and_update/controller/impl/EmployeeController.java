package com.example.lab_java_add_and_update.controller.impl;

import com.example.lab_java_add_and_update.controller.interfaces.IEmployeeController;
import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Status;
import com.example.lab_java_add_and_update.repository.EmployeeRepository;
import com.example.lab_java_add_and_update.service.interfaces.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")

public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeId(@PathVariable Integer id) {
        return employeeService.getEmployeeId(id);

    }

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeService.getEmployeeVyStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeService.getEmployeeByDepartment(department);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
    }
}