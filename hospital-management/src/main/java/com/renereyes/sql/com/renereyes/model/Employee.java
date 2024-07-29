package com.renereyes.hospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private int employeeId;
    private String department;
    private String name;
    private String status;
}
