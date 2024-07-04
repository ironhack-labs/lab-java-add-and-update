package java_spring_lab.crud.service.impl;

import java_spring_lab.crud.model.Employee;
import java_spring_lab.crud.model.Status;
import java_spring_lab.crud.repository.EmployeeRepository;
import java_spring_lab.crud.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return null;
        return employeeOptional.get();

    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeStatus(Status status, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeDepartment(String department, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }


}
