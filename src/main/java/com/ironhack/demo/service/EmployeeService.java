package com.ironhack.demo.service;

import com.ironhack.demo.model.Employee;
import com.ironhack.demo.model.Status;
import com.ironhack.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public void updateEmployeeStatus(String id, Status status) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setStatus(status);
            employeeRepository.save(employee);
        }
    }

    public void updateEmployeeDepartment(String id, String department) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }
}
