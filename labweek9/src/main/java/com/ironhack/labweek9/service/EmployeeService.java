package com.ironhack.labweek9.service;

import com.ironhack.labweek9.model.Employee;
import com.ironhack.labweek9.model.EmployeeDepartmentOnlyDTO;
import com.ironhack.labweek9.model.EmployeeStatusOnlyDTO;
import com.ironhack.labweek9.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeStatus(Integer id, EmployeeStatusOnlyDTO status) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if(optEmployee.isEmpty()) return null;
        Employee employee = optEmployee.get();
        employee.setStatus(status.getStatus());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeDepartment(Integer id, EmployeeDepartmentOnlyDTO department) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if(optEmployee.isEmpty()) return null;
        Employee employee = optEmployee.get();
        String departmentName = department.getDepartment();
        if(departmentName != null || !departmentName.isEmpty()) {
            employee.setDepartment(departmentName);
            return employeeRepository.save(employee);
        }
        return employee;
    }
}
