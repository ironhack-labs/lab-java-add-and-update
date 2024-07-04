package ironhack.schl.Lab4_04.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class DoctorDepartmentDTO {
    @NotEmpty(message = "The department cannot be empty")
    private String department;

    public String getDepartment() {
        return department;
    }

}
