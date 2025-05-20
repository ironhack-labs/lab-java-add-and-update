package com.ironhack.Lab404AddandUpdate.service.interfaces;


import com.ironhack.Lab404AddandUpdate.model.Employee;
import com.ironhack.Lab404AddandUpdate.model.EmployeeStatus;

import java.util.List;

public interface IEmployeeService {

    Employee saveEmployee(Employee employee);


    void updateEmployeeHospital(Long hospitalId, Long employeeId);


    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);


    List<Employee> findEmployeeByStatus(EmployeeStatus status);

    List<Employee> findEmployeeByDepartment(String department);

    Employee updateEmployeeStatus(Long id, String newStatus);

    Employee updateEmployeeDepartment(Long id, String newDepartment);
}
