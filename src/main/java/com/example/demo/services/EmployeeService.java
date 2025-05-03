package com.example.demo.services;

import com.example.demo.dtos.EmployeePatchDTO;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //Add new doctor
    public Employee createEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }

    //Change doctor status
    //Update doctor´s department

   public Employee modifyEmployee(long id, EmployeePatchDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(id);
        if (employeeDTO.getStatus() != null) {
            existingEmployee.setStatus(employeeDTO.getStatus());
        }
       if (employeeDTO.getDepartment() != null) {
           existingEmployee.setDepartment(employeeDTO.getDepartment());
       }
        return employeeRepository.save(existingEmployee);
   }
}

