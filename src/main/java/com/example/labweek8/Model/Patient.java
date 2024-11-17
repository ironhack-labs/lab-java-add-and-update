package com.example.labweek8.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table (name="patient")

public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long patientId;

    private String patientName;
    private LocalDate dateOfBirth;


    @OneToOne
    @JoinColumn(name = "admitted_by") // in the database you will have a column with just the id of the employee connected
    private Employee doctor;

    public Patient(String patientName, LocalDate dateOfBirth, Employee doctor) {
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }
}
