package com.labs.lab_add_and_update.controller.impl;

import com.labs.lab_add_and_update.controller.dto.ChangeStatusDTO;
import com.labs.lab_add_and_update.controller.dto.UpdateEmployeeDepartmentDTO;
import com.labs.lab_add_and_update.model.Employee;
import com.labs.lab_add_and_update.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeService.getAllDoctors();
    }

    @GetMapping("/doctor/{employeeId}")
    public Employee getDoctorById(@PathVariable Long employeeId) {
        return employeeService.getDoctorById(employeeId);
    }

    @GetMapping("/doctorsByDepartment")
    public List<Employee> getDoctorsByDepartment(@RequestParam String department) {
        return employeeService.getDoctorsByDepartment(department);
    }

    @GetMapping("/doctorsByStatus")
    public List<Employee> getDoctorsByStatus(@RequestParam String status) {
        return employeeService.getDoctorsByStatus(status);
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDoctor(@RequestBody @Valid Employee employee) {
        employeeService.addDoctor(employee);
    }

    @PatchMapping("/doctor/status/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctorStatus(@RequestBody @Valid ChangeStatusDTO changeStatusDTO, @PathVariable Long employeeId) {
        employeeService.updateDoctorStatus(employeeId, changeStatusDTO.getStatus());
    }

    @PatchMapping("/doctor/department/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@RequestBody @Valid UpdateEmployeeDepartmentDTO updateEmployeeDepartmentDTO, @PathVariable Long employeeId) {
        employeeService.updateDoctorDepartment(employeeId, updateEmployeeDepartmentDTO.getDepartment());
    }
}
