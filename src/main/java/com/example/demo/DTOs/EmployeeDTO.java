package com.example.demo.DTOs;

public class EmployeeDTO {

    private String status;
    private String department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String status, String department) {
        this.status = status;
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "status='" + status + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
