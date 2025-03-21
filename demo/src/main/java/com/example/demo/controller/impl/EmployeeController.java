package com.example.demo.controller.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeStatus;
import com.example.demo.model.Patient;
import com.example.demo.service.imlp.EmployeeService;
import com.example.demo.service.imlp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PatientService patientService;

    @PostMapping("/doctors")
    public void createDoctor(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/doctors/status/{id}")
    public void updateStatusDoctor(@PathVariable("id") Integer id, @RequestParam("status") EmployeeStatus employeeStatus) {
        employeeService.updateStatus(id,employeeStatus);
    }

    @PutMapping("/doctors/department/{id}")
    public void updateDepartmentDoctor(@PathVariable("id") Integer id, @RequestParam("department") String department) {
        employeeService.updateDepartment(id,department);
    }
}
