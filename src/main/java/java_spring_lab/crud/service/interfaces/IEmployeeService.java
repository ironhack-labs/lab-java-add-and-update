package java_spring_lab.crud.service.interfaces;

import java_spring_lab.crud.model.Employee;
import java_spring_lab.crud.model.Status;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    void saveEmployee(Employee employee);

    void updateEmployeeStatus(Status status, Integer id);

    void updateEmployeeDepartment(String department, Integer id);
}
