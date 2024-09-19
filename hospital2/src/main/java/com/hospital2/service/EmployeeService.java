package com.hospital2.service;

import com.hospital2.enums.Department;
import com.hospital2.enums.Status;
import com.hospital2.model.Employee;
import com.hospital2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Department department;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setStatus(updatedEmployee.getStatus());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeStatus(Long id, String status) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setStatus(Status.valueOf(status));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
}
