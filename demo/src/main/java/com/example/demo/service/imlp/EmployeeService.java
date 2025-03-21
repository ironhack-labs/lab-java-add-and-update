package com.example.demo.service.imlp;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeStatus;
import com.example.demo.model.Patient;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PatientRepository patientRepository;

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateStatus(Integer id, EmployeeStatus employeeStatus){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        employeeOptional.get().setEmployeeStatus(employeeStatus);
        employeeRepository.save(employeeOptional.get());
    }

    public void updateDepartment(Integer id, String department){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        employeeOptional.get().setDepartment(department);
        employeeRepository.save(employeeOptional.get());
    }

}
