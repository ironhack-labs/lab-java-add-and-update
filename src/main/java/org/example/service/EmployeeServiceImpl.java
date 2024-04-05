package org.example.service;

import org.example.model.Employee;
import org.example.model.Status;
import org.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void updateEmployeeStatus(String id, Status status) {
        employeeRepository.findById(id).ifPresent(employee -> {
            employee.setStatus(status);
            employeeRepository.save(employee);
        });
    }

    @Override
    public void updateEmployeeDepartment(String id, String department) {
        employeeRepository.findById(id).ifPresent(employee -> {
            employee.setDepartment(department);
            employeeRepository.save(employee);
        });
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<List<Employee>> findByStatus(Status status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public Optional<List<Employee>> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public void save(Employee doctor) {
        employeeRepository.save(doctor);
    }

}
