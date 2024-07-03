package com.ironhack.intro_springBoot.controller.impl;

import com.ironhack.intro_springBoot.controller.interfaces.IEmployeeController;
import com.ironhack.intro_springBoot.model.Employee;
import com.ironhack.intro_springBoot.repository.EmployeeRepository;
import com.ironhack.intro_springBoot.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);

    }

    @GetMapping("/employees/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable String status) {
        return employeeService.getEmployeeByStatus(status);

    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);

    }

}
