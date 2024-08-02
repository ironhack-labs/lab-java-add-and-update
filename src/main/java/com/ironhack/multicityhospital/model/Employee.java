package com.ironhack.multicityhospital.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    private Long employeeId;

    private String name;
    private String status;
    private String department;

    public Employee(Long employeeId, String name, String status, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.status = status;
        this.department = department;
    }

}