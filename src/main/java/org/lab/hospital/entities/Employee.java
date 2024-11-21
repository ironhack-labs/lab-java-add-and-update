package org.lab.hospital.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Employee {
    @Id
    private Long employeeId;

    private String department;
    private String name;
    private String status;

    public Employee(long l, String cardiology, String alonsoFlores, String onCall) {
    }

    public Employee() {

    }
}
