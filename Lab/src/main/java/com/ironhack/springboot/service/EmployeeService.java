package com.ironhack.springboot.service;

import com.ironhack.springboot.enums.EmployeeStatus;
import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.model.Patient;
import com.ironhack.springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    //    Add new doctor: Create a route to add a new doctor.
    public void addEmployee(Long employeeId, String department, String name, EmployeeStatus status) {
        log.info("Adding new employee");
        Employee employee = new Employee(employeeId, department, name, status);
        employeeRepository.save(employee);
    }


    public void changeEmployeeStatus(Long employeeId, EmployeeStatus status) {
        log.info("Changing status of employee with id {}", employeeId);
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    public void updateEmployeeDepartment(Long employeeId, String department) {
        log.info("Changing department of employee with id {}", employeeId);
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }


}
