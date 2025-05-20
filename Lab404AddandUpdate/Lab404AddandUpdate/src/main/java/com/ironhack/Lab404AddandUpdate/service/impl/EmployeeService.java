package com.ironhack.Lab404AddandUpdate.service.impl;

import com.ironhack.Lab404AddandUpdate.model.Employee;
import com.ironhack.Lab404AddandUpdate.model.EmployeeStatus;
import com.ironhack.Lab404AddandUpdate.model.Hospital;
import com.ironhack.Lab404AddandUpdate.repository.EmployeeRepository;
import com.ironhack.Lab404AddandUpdate.repository.HospitalRepository;
import com.ironhack.Lab404AddandUpdate.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeHospital(Long hospitalId, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        employee.setHospital(hospital);
        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor " + id + " not found");
        return employeeOptional.get();
    }

    @Override
    public List<Employee> findEmployeeByStatus(EmployeeStatus status) {
        return employeeRepository.findAllByStatus(status);
    }

    @Override
    public List<Employee> findEmployeeByDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    @Override
    public Employee updateEmployeeStatus(Long id, String newStatus) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor " + id + " not found");

        Employee employee = employeeOptional.get();
        employee.setStatus(EmployeeStatus.valueOf(newStatus));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeDepartment(Long id, String newDepartment) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor " + id + " not found");
        Employee employee = employeeOptional.get();
        employee.setDepartment(newDepartment);
        return employeeRepository.save(employee);

    }
}
