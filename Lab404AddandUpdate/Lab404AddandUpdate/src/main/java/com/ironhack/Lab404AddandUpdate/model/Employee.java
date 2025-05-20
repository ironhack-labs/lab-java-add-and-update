package com.ironhack.Lab404AddandUpdate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    private Long employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

@ManyToOne
    @JoinColumn(name = "hospId")
    private Hospital hospital;


}
