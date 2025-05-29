package com.example.demo.Service.Interfaces;

import com.example.demo.Model.Employee;
import com.example.demo.Model.EmployeeStatus;

public interface IEmployeeService {
    void saveEmployee(Employee employee);

    Employee updateEmployeeStatus(Long id, EmployeeStatus status);
    Employee updateEmployeeDepartment(Long id, String department);

}
