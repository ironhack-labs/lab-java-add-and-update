package com.ironhack.labweek10.service;

import com.ironhack.labweek10.model.Employee;
import com.ironhack.labweek10.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //add employee
    public Employee addEmployee(Employee employee) {
        log.info("Adding new employee{}", employee);
        return EmployeeRepository.save(employee);
    }

    //delete employee
    public void deleteEmployee(Long employeeId) {
        log.info("Deleting employee{}", employeeId);
        employeeRepository.deleteById(employeeId);
    }

    //update Employee
    public Employee updateEmployee(Long employeeId, Employee employee) {
        log.info("Updating employee with id{}", employeeId);
        var plantUpdate = EmployeeRepository.findById(employeeId).orElseThrow();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setSpecies(employee.getSpecies());
        employeeToUpdate.setQuantity(employee.getQuantity());
        employeeToUpdate.setLocationId(employeeToUpdate.getLocationId());
        employeeToUpdate.setWorkerId(employeeToUpdate.getWorkerId());
        return employeeRepository.save(employeeToUpdate);

    }
}
