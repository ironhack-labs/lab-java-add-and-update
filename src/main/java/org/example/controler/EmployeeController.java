package org.example.controler;

import org.example.model.Employee;
import org.example.model.Status;
import org.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctors() {
        return employeeService.findAll();
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getDoctorById(@PathVariable(name="id") String employeeID) {
        return employeeService.findById(employeeID).get();
    }

    @GetMapping("/doctors/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctorsByStatus(@PathVariable(name="status") Status status) {
        return employeeService.findByStatus(status).get();
    }

    @GetMapping("/doctors/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getDoctorsByDepartment(@PathVariable(name = "department")String department) {
        return employeeService.findByDepartment(department).get();
    }

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDoctor(@RequestBody Employee doctor) {
        employeeService.save(doctor);
    }

    @PatchMapping("/doctors/status/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@PathVariable String id, @RequestBody Status status) {
        employeeService.updateEmployeeStatus(id, status);

    }

    @PatchMapping("/doctors/department/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@PathVariable String id, @RequestBody String department) {
        employeeService.updateEmployeeDepartment(id, department);

    }

}
