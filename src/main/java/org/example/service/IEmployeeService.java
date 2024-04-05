package org.example.service;

import org.example.model.Employee;
import org.example.model.Status;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    void updateEmployeeStatus(String id, Status status);

    void updateEmployeeDepartment(String id, String department);

    List<Employee> findAll();
    Optional<Employee> findById(String id);
    Optional<List<Employee>> findByStatus(Status status);
    Optional<List<Employee>> findByDepartment(String department);

    void save(Employee doctor);
}
