package com.labs.lab402.controller.dto;

import com.labs.lab402.model.STATUS;
import jakarta.validation.constraints.NotEmpty;

public class DoctorDepartmentDTO {
    @NotEmpty(message = "Department cannot be empty - dto")
    private String department;

    public String getDepartment() {
        return department;
    }
}
