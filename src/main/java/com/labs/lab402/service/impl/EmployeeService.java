package com.labs.lab402.service.impl;

import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;
import com.labs.lab402.repository.EmployeeRepository;
import com.labs.lab402.service.interfaces.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(Integer.parseInt(id));
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getAllEmployeesByStatus(STATUS status) {
        return employeeRepository.findAllByStatus(status);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    @Override
    public void saveEmployee(Employee employee) {
        log.info("Log testing");
        log.info("Attempting to save "+ employee.toString());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeStatus(STATUS status, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        log.info("Attempting to save "+employee.toString());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeDepartment(String department, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
