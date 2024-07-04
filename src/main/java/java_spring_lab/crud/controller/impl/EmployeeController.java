package java_spring_lab.crud.controller.impl;

import java_spring_lab.crud.controller.dto.EmployeeDepartmentDTO;
import java_spring_lab.crud.model.Employee;
import java_spring_lab.crud.model.Status;
import java_spring_lab.crud.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/doctors")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/doctors/{id}")
    public Employee getEmployeesById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

//    @PatchMapping("/doctors/status/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateEmployeeStatus(@RequestBody EmployeeStatusDto employeeStatusDto, @PathVariable Integer id){
//        employeeService.updateEmployeeStatus(employeeStatusDto.getStatus(), id);
//    }

    @PatchMapping("/doctors/status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@RequestBody Status status, @PathVariable Integer id){
        employeeService.updateEmployeeStatus(status, id);
    }

    @PatchMapping("/doctors/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@RequestBody EmployeeDepartmentDTO employeeDepartmentDTO, @PathVariable Integer id){
        employeeService.updateEmployeeDepartment(employeeDepartmentDTO.getDepartment(), id);
    }


}
