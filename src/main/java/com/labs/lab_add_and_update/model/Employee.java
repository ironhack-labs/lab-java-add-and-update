package com.labs.lab_add_and_update.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Long employeeId;
    @NotBlank(message = "Department cannot be blank")
    private String department;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @NotNull(message = "Status cannot be null")
    @Size(min = 1, max = 10, message = "Status must be between 1 and 10 characters")
    private String status;
}
