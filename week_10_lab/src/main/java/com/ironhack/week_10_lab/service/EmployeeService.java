package com.ironhack.week_10_lab.service;

import com.ironhack.week_10_lab.model.Employee;
import com.ironhack.week_10_lab.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
