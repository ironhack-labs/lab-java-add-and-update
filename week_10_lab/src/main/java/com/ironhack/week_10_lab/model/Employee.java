package com.ironhack.week_10_lab.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    private int employeeId;

    private String department;

    private String name;

    public Employee(String department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ON, OFF, ON_CALL
    }
}

