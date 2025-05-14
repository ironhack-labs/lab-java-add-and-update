// DTO
package com.ironhack.hospital.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentDTO {
    @NotNull(message = "Department must not be null")
    private String department;
}