package com.ironhack.labjavaaddandupdate.DTO;

import com.ironhack.labjavaaddandupdate.JavaClass.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeStatusDTO {
         // Create a route to change a doctor's status.
    @NotNull
    private Status status;
}
