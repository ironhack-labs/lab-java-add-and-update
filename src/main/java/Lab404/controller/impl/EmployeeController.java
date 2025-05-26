package Lab404.controller.impl;


import Lab404.model.Employee;
import Lab404.model.EmployeeStatus;
import Lab404.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    Lab404.repository.EmployeeRepository employeeRepository;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
    //see if empty
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    // findByDepartment
    @GetMapping("/doctors/department/{department}")
    public List<Employee> findAllByDepartment(@PathVariable String department) {
        return employeeRepository.findAllByDepartment(department);

    }

    //Get doctors by status:
    @GetMapping("/doctors/status/{employeeStatus}")
    public List<Employee> findAllByEmployeeStatus(@PathVariable EmployeeStatus employeeStatus) {
        return employeeRepository.findAllByEmployeeStatus(employeeStatus);
    }
    //add another doc
    @PostMapping("/doctors/new/")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveDoctor(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping("/doctors/{id}/department")
    public Employee updateDepartment(@PathVariable Integer id, @RequestBody String department){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
            employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

}