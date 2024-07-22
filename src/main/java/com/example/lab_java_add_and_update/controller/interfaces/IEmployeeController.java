package com.example.lab_java_add_and_update.controller.interfaces;

import com.example.lab_java_add_and_update.model.Employee;

import java.util.List;

public interface IEmployeeController {
    List<Employee> getAllEmployee();
    Employee getEmployeeId(Integer id);
}
