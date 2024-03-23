package com.example.intro.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.intro.model.utils.Status;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "employees")
@DynamicUpdate
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    Status status;
}
