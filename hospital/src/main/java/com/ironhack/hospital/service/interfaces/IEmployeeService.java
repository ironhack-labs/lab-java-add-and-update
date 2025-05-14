package com.ironhack.hospital.service.interfaces;

import java.util.List;

import com.ironhack.hospital.model.Employee;
import com.ironhack.hospital.model.Employee.Status;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeeByStatus(Status status);

    List<Employee> findByDepartment(String department);

    Employee saveEmployee(Employee employee);

    Employee updateEmployeeStatusById(Integer id, Status status);

    Employee updateEmployeeStatusByDepartment(Integer id, String department);
}
