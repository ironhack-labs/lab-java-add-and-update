// DTO
package com.ironhack.hospital.controller.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientUpdateDTO {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "DOB cannot be null")
    private Date dateOfBirth;
}