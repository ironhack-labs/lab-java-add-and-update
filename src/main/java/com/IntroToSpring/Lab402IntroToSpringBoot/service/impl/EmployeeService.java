package com.IntroToSpring.Lab402IntroToSpringBoot.service.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Employee;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.EmployeeRepository;
import com.IntroToSpring.Lab402IntroToSpringBoot.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployeesByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeStatus(Long id, String status) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeDepartment(Long id, String department) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
