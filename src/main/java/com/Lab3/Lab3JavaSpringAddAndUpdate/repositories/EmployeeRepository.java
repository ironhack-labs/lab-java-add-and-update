package com.Lab3.Lab3JavaSpringAddAndUpdate.repositories;

import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
