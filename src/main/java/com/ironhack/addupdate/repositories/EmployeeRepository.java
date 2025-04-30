package com.ironhack.addupdate.repositories;

import com.ironhack.addupdate.models.Department;
import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeId (int employeeId);

    List<Employee> findByStatus(Status status);

    List<Employee> findByDepartment(Department department);
}
