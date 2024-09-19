package com.hospital2.model;


import jakarta.persistence.*;
import com.hospital2.enums.Status;
import com.hospital2.enums.Department;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Enumerated(EnumType.STRING)
    private Department department; // Cambiado a enum Department

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;
}
