package com.intro.SpringBoot.DTO;

import com.intro.SpringBoot.enums.StatusOfEmployee;
import lombok.Data;

@Data
public class EmployeeUpdateDTO {
    private StatusOfEmployee status;
    private String department;
}
