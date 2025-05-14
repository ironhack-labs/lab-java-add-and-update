package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.controller.dto.EmployeeDepartmentDTO;
import com.ironhack.hospital.controller.dto.EmployeeStatusDTO;
import com.ironhack.hospital.model.Employee;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.service.interfaces.IEmployeeService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getEmployeeByStatus(Status status) {
        return employeeService.getEmployeeByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeService.findByDepartment(department);
    }

    // POST

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    // PATCH

    // Controller
    @PatchMapping("/employees/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Employee updateStatus(@PathVariable Integer id, @RequestBody @Valid EmployeeStatusDTO employeeStatusDTO) {
        employeeService.updateEmployeeStatusById(id, employeeStatusDTO.getStatus());
        return getEmployeeById(id);
    }

    @PatchMapping("/employees/{id}/department")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Employee updateStatus(@PathVariable Integer id,
            @RequestBody @Valid EmployeeDepartmentDTO employeeDepartmentDTO) {
        employeeService.updateEmployeeStatusByDepartment(id, employeeDepartmentDTO.getDepartment());
        return getEmployeeById(id);
    }
}