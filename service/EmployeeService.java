package com.ironhack.week10lab.service;

import com.ironhack.week10lab.model.Employee;
import com.ironhack.week10lab.model.EmployeeStatus;
import com.ironhack.week10lab.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeStatus(Integer employeeId, EmployeeStatus status) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setStatus(status);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeDepartment(Integer employeeId, String department) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
}

