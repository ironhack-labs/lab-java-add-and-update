package com.ironhack.hospitalmanagement.service;

import com.ironhack.hospitalmanagement.model.Employee;
import com.ironhack.hospitalmanagement.repository.EmployeeRepository;
import com.ironhack.hospitalmanagement.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee changeEmployeeStatus(Long id, String status) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setStatus(status);
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployeeDepartment(Long id, String department) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
