package com.labs.lab_add_and_update.service.interfaces;

import com.labs.lab_add_and_update.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllDoctors();
    Employee getDoctorById(Long employeeId);
    List<Employee> getDoctorsByDepartment(String department);
    List<Employee> getDoctorsByStatus(String status);

    void addDoctor(Employee employee);
    void updateDoctorStatus(Long employeeId, String status);
    void updateDoctorDepartment(Long employeeId, String department);
}
