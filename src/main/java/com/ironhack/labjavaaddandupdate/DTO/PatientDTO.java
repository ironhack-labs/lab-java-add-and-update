package com.ironhack.labjavaaddandupdate.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PatientDTO {
    //Add new patient: Create a route to add a new patient.

    @NotBlank
    private String name;

    @NotBlank
    private String dateOfBirth;

    @NotNull
    private Integer admittedBy; // Assuming this is an employee ID
}
