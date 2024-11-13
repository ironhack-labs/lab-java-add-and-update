package com.example.lab_add_update.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Doctor admittedBy;

    public Patient() {}

    public Patient(String name, LocalDate dateOfBirth, Doctor admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    // Getters and setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Doctor admittedBy) {
        this.admittedBy = admittedBy;
    }
}
