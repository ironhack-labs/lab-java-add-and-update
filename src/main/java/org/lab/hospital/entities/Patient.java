package org.lab.hospital.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String name;
    private String dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient(long l, String jaimeJordan, String date, Employee doctor2) {
    }

    public Patient() {

    }

    public String getAdmittingDoctor() {
        return String.valueOf(false);
    }

    public void setAdmittingDoctor(String admittingDoctor) {
    }
}
