package com.example.demo.Services;

import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;



}