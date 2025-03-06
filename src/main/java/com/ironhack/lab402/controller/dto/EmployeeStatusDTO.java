package com.ironhack.lab402.controller.dto;

import com.ironhack.lab402.model.Status;
import jakarta.validation.constraints.NotNull;

public class EmployeeStatusDTO {
    @NotNull(message = "Status cannot be null")
    private Status status;

    public EmployeeStatusDTO() {
    }

    public EmployeeStatusDTO(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
