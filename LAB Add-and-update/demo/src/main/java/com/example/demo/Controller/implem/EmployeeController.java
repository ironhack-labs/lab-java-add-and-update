package com.example.demo.Controller.implem;
import com.example.demo.DTO.EmployeeDepartmentDTO;
import com.example.demo.DTO.EmployeeStatusDTO;
import com.example.demo.Model.Employee;
import com.example.demo.Service.Interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }


    @PatchMapping("/employees/{id}/status")
    public Employee updateEmployeesStatus(@PathVariable Long id, @RequestBody EmployeeStatusDTO statusDTO) {
        return employeeService.updateEmployeeStatus(id, statusDTO.getStatus());
    }

    @PatchMapping("/employees/{id}/department")
    public Employee updateEmployeeDepartment(@PathVariable Long id, @RequestBody EmployeeDepartmentDTO departmentDTO) {
        return employeeService.updateEmployeeDepartment(id, departmentDTO.getDepartment());
    }






}




