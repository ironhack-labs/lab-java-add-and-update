package com.ironhack.week10_lab.service;

import com.ironhack.week10_lab.model.Employee;
import com.ironhack.week10_lab.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployeeStatus(Integer id, String status) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setStatus(status);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public Employee updateEmployeeDepartment(Integer id, String department) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }
        return null;
    }
}


