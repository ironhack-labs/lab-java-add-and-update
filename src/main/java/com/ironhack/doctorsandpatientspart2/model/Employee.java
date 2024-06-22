package com.ironhack.doctorsandpatientspart2.model;

import com.ironhack.doctorsandpatientspart2.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    private int id;
    private String name;
    private String department;
    @Enumerated
    private Status status;

    public Employee(int id, Status status, String department, String name) {
        this.name = name;
        this.department = department;
        this.status = status;
        this.id = id;
    }
}
