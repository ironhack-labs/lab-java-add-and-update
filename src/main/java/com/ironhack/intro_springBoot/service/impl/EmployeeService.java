package com.ironhack.intro_springBoot.service.impl;

import com.ironhack.intro_springBoot.model.Employee;
import com.ironhack.intro_springBoot.repository.EmployeeRepository;
import com.ironhack.intro_springBoot.service.interfaces.IEmployeeService;
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
    public List<Employee> getEmployeeByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }


}
