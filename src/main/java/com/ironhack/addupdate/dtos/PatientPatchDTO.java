package com.ironhack.addupdate.dtos;

import com.ironhack.addupdate.models.Employee;

public class PatientPatchDTO {

    private String name;
    private String dateOfBirth;
    private Employee admittedBy;

    public PatientPatchDTO() {
    }

    public PatientPatchDTO(String name, String dateOfBirth, Employee admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }
}
