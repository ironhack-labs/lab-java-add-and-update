package com.example.demo.controllers;

import com.example.demo.dtos.EmployeePatchDTO;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

   @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getDoctorById(@PathVariable Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }


    @GetMapping("/{employeeStatus}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeRepository.findByStatus(status);
    }


//Add new doctor

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee crateEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    //Change doctor status & Update doctor´s department

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public Employee patchEmployee(@PathVariable long id,@RequestBody EmployeePatchDTO employeeDTO) {
        return employeeService.modifyEmployee(id, employeeDTO);
    }
}

