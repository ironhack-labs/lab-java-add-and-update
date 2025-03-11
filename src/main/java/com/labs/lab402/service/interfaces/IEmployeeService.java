package com.labs.lab402.service.interfaces;

import com.labs.lab402.controller.dto.DoctorDepartmentDTO;
import com.labs.lab402.controller.dto.DoctorStatusDTO;
import com.labs.lab402.model.Employee;
import com.labs.lab402.model.Patient;
import com.labs.lab402.model.STATUS;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployeesByStatus(STATUS status);
    List<Employee> getAllEmployeesByDepartment(String department);
    void saveEmployee(Employee employee);
    void updateEmployeeStatus(STATUS status, Integer id);
    void updateEmployeeDepartment(String department, Integer id);
}
