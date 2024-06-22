package com.ironhack.sprinkgweek10.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admittedBy",referencedColumnName = "id")
    private Employee admittedBy;

    public Patient(String name, LocalDate birthDate, Employee admittedBy) {
        this.name = name;
        this.birthDate = birthDate;
        this.admittedBy = admittedBy;
    }
}
