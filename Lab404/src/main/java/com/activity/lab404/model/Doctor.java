package com.activity.lab404.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")

public class Doctor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long employeeId;
    private String department;
    private String name;
    private String status;
}
