package com.ironhack.week10lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
@Data
@Table(name="employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "admittedBy",fetch = FetchType.EAGER)
    private List<Patient> patients;

    public Employee(String department, String name, EmployeeStatus status, List<Patient> patients) {
        this.department = department;
        this.name = name;
        this.status = status;
        this.patients = patients;
    }
}
