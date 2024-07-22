package com.example.lab_java_add_and_update.service.impl;

import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Status;
import com.example.lab_java_add_and_update.repository.EmployeeRepository;
import com.example.lab_java_add_and_update.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return List.of();
    }

    @Override
    public Employee getEmployeeId(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getEmployeeVyStatus(Status status) {
        return employeeRepository.findAllByStatus(status);
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


}
