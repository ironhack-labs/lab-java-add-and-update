package com.ironhack.labweek9.controller;

import com.ironhack.labweek9.model.Employee;
import com.ironhack.labweek9.model.EmployeeDepartmentOnlyDTO;
import com.ironhack.labweek9.model.EmployeeStatusOnlyDTO;
import com.ironhack.labweek9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Override
    @PostMapping("post")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @Override
    @PatchMapping("/{id}/status")
    public Employee updateEmployeeStatus(@PathVariable Integer id, @RequestBody EmployeeStatusOnlyDTO status) {
        return employeeService.updateEmployeeStatus(id, status);
    }

    @Override
    @PatchMapping("/{id}/department")
    public Employee updateEmployeeDepartment(@PathVariable Integer id, @RequestBody EmployeeDepartmentOnlyDTO department) {
        return employeeService.updateEmployeeDepartment(id, department);
    }
}
