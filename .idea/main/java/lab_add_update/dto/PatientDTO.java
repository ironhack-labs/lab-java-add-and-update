package com.example.lab_add_update.dto;

import java.time.LocalDate;

public class PatientDTO {

    private String name;
    private LocalDate dateOfBirth;
    private Long admittedBy;

    public PatientDTO() {}

    public PatientDTO(String name, LocalDate dateOfBirth, Long admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    // Getters and setters
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

    public Long getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Long admittedBy) {
        this.admittedBy = admittedBy;
    }
}

