package com.ironhack.Lab404AddandUpdate.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdDTO {
    @NotNull(message = "Id cannot be empty")
    private Long id;

}
