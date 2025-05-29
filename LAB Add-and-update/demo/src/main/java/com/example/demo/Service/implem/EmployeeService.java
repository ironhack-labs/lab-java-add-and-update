package com.example.demo.Service.implem;

import com.example.demo.Model.Employee;
import com.example.demo.Model.EmployeeStatus;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeesRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeesRepository.save(employee);
    }


    @Override
    public Employee updateEmployeeStatus(Long id, EmployeeStatus status) {
        Employee employee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setStatus(status);
        return employeesRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeDepartment(Long id, String department) {
        Employee employee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setDepartment(department);
        return employeesRepository.save(employee);
    }

}



