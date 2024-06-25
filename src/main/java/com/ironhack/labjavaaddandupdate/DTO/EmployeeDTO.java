package com.ironhack.labjavaaddandupdate.DTO;

import com.ironhack.labjavaaddandupdate.JavaClass.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    //Add new doctor: Create a route to add a new doctor.

    @NotBlank
    private String department;

    @NotBlank
    private String name;

    @NotNull
    private Status status;
}