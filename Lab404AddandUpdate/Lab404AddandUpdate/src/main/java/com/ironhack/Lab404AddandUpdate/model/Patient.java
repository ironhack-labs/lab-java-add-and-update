package com.ironhack.Lab404AddandUpdate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String patientName;
    private Date patientDateOfBirth;


    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employeeId")
    private Employee employeeId;

    public Patient(String patientName, Date patientDateOfBirth, Employee employeeId) {
        this.patientName = patientName;
        this.patientDateOfBirth = patientDateOfBirth;
        this.employeeId = employeeId;
    }
}
