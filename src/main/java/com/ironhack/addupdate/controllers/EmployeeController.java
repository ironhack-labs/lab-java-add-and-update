package com.ironhack.addupdate.controllers;

import com.ironhack.addupdate.dtos.EmployeePatchDTO;
import com.ironhack.addupdate.models.Department;
import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.models.Status;
import com.ironhack.addupdate.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //--------------------------------------------------------------------

    @GetMapping("api/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }



    @GetMapping("api/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeId(@PathVariable(name="id") int id) {
        return employeeRepository.findByEmployeeId(id);
    }


    @GetMapping("api/employee/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesStatus(@PathVariable(name="status") String status) {
        try {
            // Convertir el String recibido a Status (ENUM)
            Status statusEnum = Status.valueOf(status.toUpperCase());
            // Llamar al repositorio con el Status convertido
            return employeeRepository.findByStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            // Si el status no es válido, lanzar una excepción con código 400 (Bad Request)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value: " + status);
        }
    }
    //public Product getProductById(@PathVariable(name="id") long productId) {
    //   return productRepository.findById(productId).get();



    @GetMapping("api/employee/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesDepartment(@PathVariable(name="department") String department) {
        try {
            // Convertir el String recibido a Status (ENUM)
            Department departmentEnum = Department.valueOf(department.toUpperCase());
            // Llamar al repositorio con el Status convertido
            return employeeRepository.findByDepartment(departmentEnum);
        } catch (IllegalArgumentException e) {
            // Si el status no es válido, lanzar una excepción con código 400 (Bad Request)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid department value: " + department);
        }
    }
    //--------------------------------------------------------------------
    @PostMapping("api/employee/add-new-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);

    }

    @PatchMapping("api/employee/update-status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateStatus(@PathVariable int id, @RequestBody EmployeePatchDTO employeePatchDTO) {
        Employee exisitingEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException( HttpStatus.NOT_FOUND));

        if (employeePatchDTO.getStatus() != null) {
            exisitingEmployee.setStatus(employeePatchDTO.getStatus());
        }
        return employeeRepository.save(exisitingEmployee);


    }

    @PatchMapping("api/employee/update-department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateDepartment(@PathVariable int id, @RequestBody EmployeePatchDTO employeePatchDTO) {
        Employee exisitingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (employeePatchDTO.getDepartment() != null) {
            Department d = employeePatchDTO.getDepartment(); //NUEVO
            String dep = d.toString().toUpperCase(); //NUEVO
            exisitingEmployee.setDepartment(Department.valueOf(dep)); //NUEVO
            //exisitingEmployee.setDepartment(employeePatchDTO.getDepartment());
        }
        return employeeRepository.save(exisitingEmployee);
    }






}
