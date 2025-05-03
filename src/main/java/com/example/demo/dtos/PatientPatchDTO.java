package com.example.demo.dtos;

import com.example.demo.models.Employee;

import java.util.Date;

public class PatientPatchDTO {

    private String name;
    private Date dateOfBirth;
    private Long admittedById;

    public PatientPatchDTO() {
    }

    public PatientPatchDTO(Date dateOfBirth, Long admittedById, String name) {
        this.dateOfBirth = dateOfBirth;
        this.admittedById = admittedById;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAdmittedById() {
        return admittedById;
    }

    public void setAdmittedById(Long admittedById) {
        this.admittedById = admittedById;
    }

    @Override
    public String toString() {
        return "PatientPatchDTO{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", admittedById=" + admittedById +
                '}';
    }
}
