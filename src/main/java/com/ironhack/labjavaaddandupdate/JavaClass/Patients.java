package com.ironhack.labjavaaddandupdate.JavaClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "patients")

public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String name;
    private String dateOfBirth;
    private int admittedBy;

    //Constructor
    public Patients(int patientId, String name, String dateOfBirth, int admittedBy) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
