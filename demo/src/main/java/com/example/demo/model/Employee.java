package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    private Integer employeeId;
    private String department;
    private String employeeName;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = {"employee"}, allowSetters = true)
    List<Patient> patient = new ArrayList<>();

}
