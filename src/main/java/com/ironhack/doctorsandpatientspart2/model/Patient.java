package com.ironhack.doctorsandpatientspart2.model;

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
    @ManyToOne
    @JoinColumn(name = "admitted_by",referencedColumnName = "id")
    private Employee admitted_by;

    public Patient(String name, LocalDate birthDate, Employee admitted_by) {
        this.name = name;
        this.birthDate = birthDate;
        this.admitted_by = admitted_by;
    }
}
