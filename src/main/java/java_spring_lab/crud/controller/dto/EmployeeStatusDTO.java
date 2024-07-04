package java_spring_lab.crud.controller.dto;

import java_spring_lab.crud.model.Status;

//@Data
public class EmployeeStatusDTO {

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
