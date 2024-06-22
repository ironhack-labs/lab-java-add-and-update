package com.ironhack.sprinkgweek10.service;

import com.ironhack.sprinkgweek10.model.Employee;
import com.ironhack.sprinkgweek10.model.Status;
import com.ironhack.sprinkgweek10.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    //Add new doctor: Create a route to add a new doctor.
    @Transactional
    public Employee create(Employee employee) {
        log.info("Creating employee with name {}",employee);
        return employeeRepository.save(employee);
    }
    //Change doctor status: Create a route to change a doctor's status.
    @Transactional
    public Employee updateStatus(int id, Status status) {
        log.info("Updating status of employee with id {}",id);
        var employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setStatus(status);
        return employeeRepository.save(employeeToUpdate);
    }
    //Update doctor's department: Create a route to update a doctor's department.
    @Transactional
    public Employee updateDepartment(int id, String department) {
        log.info("Updating department of employee with id {}",id);
        var employeeDepartmentUpdate = employeeRepository.findById(id).orElseThrow();
        employeeDepartmentUpdate.setDepartment(department);
        return employeeRepository.save(employeeDepartmentUpdate);

    }


}
