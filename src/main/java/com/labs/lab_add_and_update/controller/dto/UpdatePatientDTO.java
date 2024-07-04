package com.labs.lab_add_and_update.controller.dto;

import com.labs.lab_add_and_update.model.Employee;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class UpdatePatientDTO {
    @NotEmpty
    private String name;
    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;
    private Employee admittedBy;
}
