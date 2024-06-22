package com.ironhack.doctorsandpatientspart2.service;

import com.ironhack.doctorsandpatientspart2.enums.Status;
import com.ironhack.doctorsandpatientspart2.model.Employee;
import com.ironhack.doctorsandpatientspart2.repository.EmployeeRepository;
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

    @Transactional
    //create
    public Employee create(Employee employee) {
        log.info("Creating employee {}", employee);
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //patch
    @Transactional
    public Employee updateStatus(int id, Status status) {
        log.info("Updating status of employee {}", id);
        var employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setStatus(status);
        return employeeRepository.save(employeeToUpdate);

    }

    @Transactional
    public Employee updateDepartment(int id, String department) {
        log.info("Updating department of employee {}", id);
        var employeeDepartmentUpdate = employeeRepository.findById(id).orElseThrow();
        employeeDepartmentUpdate.setDepartment(department);
        return employeeRepository.save(employeeDepartmentUpdate);
    }
}
