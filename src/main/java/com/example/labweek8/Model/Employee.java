package com.example.labweek8.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table (name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String department;
    private String name;

    @Enumerated (EnumType.STRING)
    private EmployeeStatus status;



    @OneToMany
    @JoinColumn(name= "admittedBy")
    private List<Patient> patients;
}
