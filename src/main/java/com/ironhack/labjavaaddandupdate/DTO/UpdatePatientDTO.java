package com.ironhack.labjavaaddandupdate.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdatePatientDTO {
    //Create a route to update patient information (the user should be able to update any patient information through this route).

    @NotBlank
    private String name;

    @NotBlank
    private String dateOfBirth;

    @NotNull
    private Integer admittedBy;  // Assuming this is an employee ID
}