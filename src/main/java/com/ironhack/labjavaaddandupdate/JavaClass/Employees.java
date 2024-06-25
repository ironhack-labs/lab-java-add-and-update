package com.ironhack.labjavaaddandupdate.JavaClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "employees")

public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    //Constructor
    public Employees(int employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }
}
