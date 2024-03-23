package com.example.intro.dtos;

import com.example.intro.model.utils.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EmployeeDTO {
    @Enumerated(EnumType.STRING)
    Status status;
    String department;
}
