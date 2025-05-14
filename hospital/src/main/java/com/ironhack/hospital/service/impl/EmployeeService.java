package com.ironhack.hospital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ironhack.hospital.model.Employee;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.repository.EmployeeRepository;
import com.ironhack.hospital.service.interfaces.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty())
            return null;
        return employeeOptional.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> getEmployeeByStatus(Status status) {
        List<Employee> employeeOptional = employeeRepository.findByStatus(status);
        if (employeeOptional.isEmpty())
            return null;
        return employeeOptional;
    }

    @Override
    public Employee updateEmployeeStatusById(Integer id, Status status) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeStatusByDepartment(Integer id, String department) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        List<Employee> employeeOptional = employeeRepository.findByDepartment(department);
        if (employeeOptional.isEmpty())
            return null;
        return employeeOptional;
    }
}