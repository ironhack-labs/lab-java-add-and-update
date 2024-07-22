package com.example.lab_java_add_and_update.service.interfaces;

import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Status;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeId(Integer id);

    List<Employee> getEmployeeVyStatus(Status status);

    List<Employee> getEmployeeByDepartment(String department);

    void saveEmployee(Employee employee);
}
