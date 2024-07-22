package com.example.lab_java_add_and_update.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private Integer Id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    Status status;

    public Employee(Integer id, String department, String name, Status status) {
        Id = id;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
