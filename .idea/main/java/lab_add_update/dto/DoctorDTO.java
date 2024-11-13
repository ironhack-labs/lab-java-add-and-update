package com.example.lab_add_update.dto;

public class DoctorDTO {

    private String department;
    private String name;
    private String status;

    public DoctorDTO() {}

    public DoctorDTO(String department, String name, String status) {
        this.department = department;
        this.name = name;
        this.status = status;
    }

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
