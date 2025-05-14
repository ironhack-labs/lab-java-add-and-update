// DTO
package com.ironhack.hospital.controller.dto;

import com.ironhack.hospital.model.Employee.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeStatusDTO {
    @NotNull(message = "Status must be: ON, OFF or ON_CALL")
    private Status status;
}