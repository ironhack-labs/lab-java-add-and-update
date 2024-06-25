package com.ironhack.labjavaaddandupdate.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateEmployeeDepartmentDTO {
    // Create a route to update a doctor's department.
    @NotBlank
    private String department;
}