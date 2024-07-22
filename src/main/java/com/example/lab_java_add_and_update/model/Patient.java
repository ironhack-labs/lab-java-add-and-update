package com.example.lab_java_add_and_update.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Employee admittedBy;


    public Patient(Integer id, String name, LocalDate dateOfBirth, Employee admittedBy) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}