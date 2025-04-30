package com.ironhack.addupdate.dtos;

import com.ironhack.addupdate.models.Department;
import com.ironhack.addupdate.models.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;

public class EmployeePatchDTO {

    private Department department;
    private String name;
    private Status status;

    public EmployeePatchDTO() {
    }

    public EmployeePatchDTO(Department department, String name, Status status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
