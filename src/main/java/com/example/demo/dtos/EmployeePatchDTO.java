package com.example.demo.dtos;

public class EmployeePatchDTO {
    private String status;
    private String department;

    public EmployeePatchDTO(String status) {
    }

    public EmployeePatchDTO(String department, String status) {
        this.department = department;
        this.status = status;
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
        return "EmployeePatchStatusDTO{" +
                "status='" + status + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
