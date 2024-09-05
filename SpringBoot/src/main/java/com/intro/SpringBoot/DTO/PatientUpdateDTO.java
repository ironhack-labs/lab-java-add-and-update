package com.intro.SpringBoot.DTO;

import com.intro.SpringBoot.model.Employee;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientUpdateDTO {
    private String name;
    private LocalDate dateOfBirth;
    private Employee employeeId;
}
