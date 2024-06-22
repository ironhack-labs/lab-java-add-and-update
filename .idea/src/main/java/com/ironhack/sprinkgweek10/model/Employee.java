package com.ironhack.sprinkgweek10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "doctors")
public class Employee {
    @Id
    private int id;
    private String name;
    private String department;
    @Enumerated
    private Status status;

    public Employee(int id, String name, String department, Status status) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.status = status;
    }
}
