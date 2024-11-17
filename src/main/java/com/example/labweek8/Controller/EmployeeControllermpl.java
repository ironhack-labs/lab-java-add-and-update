package com.example.labweek8.Controller;

import com.example.labweek8.DTO.EmployeeDepartmentDTO;
import com.example.labweek8.DTO.EmployeeStatusOnlyDTO;
import com.example.labweek8.Model.Employee;
import com.example.labweek8.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/employees")

public class EmployeeControllermpl {

    private final EmployeeService employeeService;

        public EmployeeControllerImpl(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
    }

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
        public Employee updateEmployeeDepartment(@PathVariable Integer id, @RequestBody EmployeeDepartmentDTO department) {
            return employeeService.updateEmployeeDepartment(id, department);
        }
}
