package com.ironhack.lab402.controller.interfaces;

import com.ironhack.lab402.controller.dto.EmployeeDepartmentDTO;
import com.ironhack.lab402.controller.dto.EmployeeStatusDTO;
import com.ironhack.lab402.model.Employee;
import com.ironhack.lab402.model.Status;

import java.util.List;

public interface IEmployeeController {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    List<Employee> getEmployeesByStatus(Status status);

    List<Employee> getEmployeesByDepartment(String department);

    // ************************** LAB 4.04 **************************

    void saveEmployee(Employee employee);

    void updateEmployeeStatus(EmployeeStatusDTO employeeStatusDTO, Integer employeeId);

    void updateEmployeeDepartment(EmployeeDepartmentDTO employeeDepartmentDTO, Integer employeeId);
}
