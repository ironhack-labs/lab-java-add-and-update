package com.labs.lab402.controller.interfaces;

import com.labs.lab402.controller.dto.DoctorDepartmentDTO;
import com.labs.lab402.controller.dto.DoctorStatusDTO;
import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;

import java.util.List;

public interface IEmployeeController {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    List<Employee> getAllEmployeesByStatus(STATUS status);
    List<Employee> getAllEmployeesByDepartment(String department);
    void saveEmployee(Employee employee);
    void updateEmployeeStatus(DoctorStatusDTO doctorStatusDTO,Integer id);
    void updateEmployeeDepartment(DoctorDepartmentDTO doctorDepartmentDTO, Integer id);
}
