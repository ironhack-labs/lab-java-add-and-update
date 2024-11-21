package org.lab.hospital.services;



import org.lab.hospital.entities.Employee;
import org.lab.hospital.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByStatus(String status) {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getStatus().equalsIgnoreCase(status))
                .toList();
    }
}
