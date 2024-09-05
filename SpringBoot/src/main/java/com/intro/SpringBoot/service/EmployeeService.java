package com.intro.SpringBoot.service;

import com.intro.SpringBoot.DTO.EmployeeUpdateDTO;
import com.intro.SpringBoot.controller.EmployeeController;
import com.intro.SpringBoot.enums.StatusOfEmployee;
import com.intro.SpringBoot.model.Employee;
import com.intro.SpringBoot.model.Patient;
import com.intro.SpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }

    public Optional<Employee> getEmployeeById(Integer id) { return employeeRepository.findById(id); }

    public List<Employee> getEmployeesByStatus(StatusOfEmployee status){
        return employeeRepository.findByStatus(status);
    }

    public List<Employee> getEmployeesByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployeePartially(Integer id, EmployeeUpdateDTO employeeUpdateDTO){

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if(employeeOptional.isPresent() && employeeUpdateDTO.getStatus() != null && employeeUpdateDTO.getDepartment() != null){
            Employee employee = employeeOptional.get();
            employee.setStatus(employeeUpdateDTO.getStatus());
            employee.setDepartment(employeeUpdateDTO.getDepartment());
            return Optional.of(employeeRepository.save(employee));
        }
        else if(employeeOptional.isPresent() && employeeUpdateDTO.getStatus() != null){
            Employee employee = employeeOptional.get();
            employee.setStatus(employeeUpdateDTO.getStatus());
            return Optional.of(employeeRepository.save(employee));
        }
        else if(employeeOptional.isPresent() && employeeUpdateDTO.getDepartment() != null){
            Employee employee = employeeOptional.get();
            employee.setDepartment(employeeUpdateDTO.getDepartment());
            return Optional.of(employeeRepository.save(employee));
        }
        return Optional.empty();
    }

}
