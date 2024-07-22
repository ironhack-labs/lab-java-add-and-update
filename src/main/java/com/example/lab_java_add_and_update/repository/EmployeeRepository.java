package com.example.lab_java_add_and_update.repository;

import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findById(Integer id);
    List<Employee> findAllByDepartment(String department);
    List<Employee> findAllByName(String name);
    List<Employee> findAllByStatus(Status status);

}