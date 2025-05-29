package com.example.demo.DTO;

import java.time.LocalDate;

public class PatientUpdateDTO {
    private String name;
    private LocalDate dateOfBirth;
    private Long admittedById;


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Long getAdmittedById() { return admittedById; }
    public void setAdmittedById(Long admittedById) { this.admittedById = admittedById; }
}

