package com.example.labweek8.Controller;


import com.example.labweek8.DTO.EmployeeDepartmentDTO;
import com.example.labweek8.Model.Employee;
import com.example.labweek8.Model.EmployeeStatus;

public class EmployeeController {
    public Employee createEmployee (Employee employee);
    public Employee updateEmployeeStatus (Integer id, EmployeeStatus status);
    public EmployeeupdateEmployeeDepartment (Integer id, EmployeeDepartmentDTO department);

}
