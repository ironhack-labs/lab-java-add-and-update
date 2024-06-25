package com.ironhack.labjavaaddandupdate.Repositories;

import com.ironhack.labjavaaddandupdate.JavaClass.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}