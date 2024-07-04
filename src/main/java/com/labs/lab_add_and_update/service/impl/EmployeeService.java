package com.labs.lab_add_and_update.service.impl;

import com.labs.lab_add_and_update.model.Employee;
import com.labs.lab_add_and_update.repository.EmployeeRepository;
import com.labs.lab_add_and_update.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getDoctorById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getDoctorsByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> getDoctorsByStatus(String status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public void addDoctor(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateDoctorStatus(Long employeeId, String status) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    @Override
    public void updateDoctorDepartment(Long employeeId, String department) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }
}
