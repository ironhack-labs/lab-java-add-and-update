package com.ironhack.labjavaaddandupdate.Controller;

import com.ironhack.labjavaaddandupdate.DTO.EmployeeDTO;
import com.ironhack.labjavaaddandupdate.DTO.UpdateEmployeeDepartmentDTO;
import com.ironhack.labjavaaddandupdate.DTO.UpdateEmployeeStatusDTO;
import com.ironhack.labjavaaddandupdate.JavaClass.Employees;
import com.ironhack.labjavaaddandupdate.Repositories.EmployeesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @PostMapping
    public ResponseEntity<Employees> addNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        Employees employee = new Employees();
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setName(employeeDTO.getName());
        employee.setStatus(employeeDTO.getStatus());

        Employees savedEmployee = employeesRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Create a route to change a doctor's status.
    @PutMapping("/{id}/status")
    public ResponseEntity<Employees> updateEmployeeStatus(@PathVariable Integer id, @RequestBody @Valid UpdateEmployeeStatusDTO updateEmployeeStatusDTO) {
        Optional<Employees> employeeOptional = employeesRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employees employee = employeeOptional.get();
            employee.setStatus(updateEmployeeStatusDTO.getStatus());
            Employees updatedEmployee = employeesRepository.save(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a route to update a doctor's department.
    @PutMapping("/{id}/department")
    public ResponseEntity<Employees> updateEmployeeDepartment(@PathVariable Integer id, @RequestBody @Valid UpdateEmployeeDepartmentDTO updateEmployeeDepartmentDTO) {
        Optional<Employees> employeeOptional = employeesRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employees employee = employeeOptional.get();
            employee.setDepartment(updateEmployeeDepartmentDTO.getDepartment());
            Employees updatedEmployee = employeesRepository.save(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
