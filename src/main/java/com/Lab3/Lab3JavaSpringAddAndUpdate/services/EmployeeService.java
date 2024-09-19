package com.Lab3.Lab3JavaSpringAddAndUpdate.services;

import com.Lab3.Lab3JavaSpringAddAndUpdate.dto.EmployeeDTO;
import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Lab3.Lab3JavaSpringAddAndUpdate.repositories.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Optional<Employee> updateEmployeeStatus(Long id, EmployeeDTO status){
        if(employeeRepository.existsById(id)){
            Employee employee = employeeRepository.getById(id);
            employee.setEmployeeStatus(status.getEmployeeStatus());
            return Optional.of(employeeRepository.save(employee));
        }
        return Optional.empty();
    }

    public Optional<Employee> updateEmployeeDepartment(Long id, EmployeeDTO department){
        if(employeeRepository.existsById(id)){
            Employee employee = employeeRepository.getById(id);
            employee.setEmployeeStatus(department.getEmployeeStatus());
            return Optional.of(employeeRepository.save(employee));
        }
        return Optional.empty();
    }

}
