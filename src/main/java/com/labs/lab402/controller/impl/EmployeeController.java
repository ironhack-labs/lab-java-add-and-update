package com.labs.lab402.controller.impl;

import com.labs.lab402.controller.dto.DoctorDepartmentDTO;
import com.labs.lab402.controller.dto.DoctorStatusDTO;
import com.labs.lab402.controller.interfaces.IEmployeeController;
import com.labs.lab402.model.Employee;
import com.labs.lab402.model.STATUS;
import com.labs.lab402.service.interfaces.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/cool")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    @Override
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/status/{status}")
    @Override
    public List<Employee> getAllEmployeesByStatus(@PathVariable STATUS status) {
        return employeeService.getAllEmployeesByStatus(status);
    }

    @GetMapping("/employee/department/{department}")
    @Override
    public List<Employee> getAllEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getAllEmployeesByDepartment(department);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void saveEmployee(@RequestBody @Valid Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @Override
    @PatchMapping("/employees/status/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployeeStatus(@RequestBody @Valid DoctorStatusDTO doctorStatusDTO, @PathVariable Integer id){
        employeeService.updateEmployeeStatus(doctorStatusDTO.getStatus(),id);
    }

    @Override
    @PatchMapping("/employees/department/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployeeDepartment(@RequestBody @Valid DoctorDepartmentDTO doctorDepartmentDTO,@PathVariable Integer id) {
        employeeService.updateEmployeeDepartment(doctorDepartmentDTO.getDepartment(), id);
    }


}
