package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patient_id;

    private LocalDate dateOfBirth;
    private String patientName;

    @ManyToOne
    @JoinColumn(name = "admittedBy", referencedColumnName = "employeeId")
    private Employee employee;

}
