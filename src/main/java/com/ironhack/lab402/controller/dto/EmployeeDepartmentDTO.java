package com.ironhack.lab402.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class EmployeeDepartmentDTO {
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    public EmployeeDepartmentDTO() {
    }

    public EmployeeDepartmentDTO(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
