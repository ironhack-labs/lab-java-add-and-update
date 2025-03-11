package com.labs.lab402.controller.dto;

import com.labs.lab402.model.STATUS;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DoctorStatusDTO {
    @NotNull(message = "Status cannot be null - dto")
    private STATUS status;

    public STATUS getStatus() {
        return status;
    }
}
