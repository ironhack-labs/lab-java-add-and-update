package com.Lab3.Lab3JavaSpringAddAndUpdate.dto;

import com.Lab3.Lab3JavaSpringAddAndUpdate.enums.EmployeeStatus;
import lombok.Data;

@Data
public class EmployeeDTO {

    public EmployeeStatus employeeStatus;
    public String department;

}
