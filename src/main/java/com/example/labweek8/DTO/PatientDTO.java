package com.example.labweek8.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private String name;

    private LocalDate dateOfBirth;

    private Integer doctor;
}
