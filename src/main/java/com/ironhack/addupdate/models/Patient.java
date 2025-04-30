package com.ironhack.addupdate.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="patient")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private int patientId;

    @NotBlank(message = "El nombre no puede estar vacío!")
    private String name;

    //@Column(name="date_of_bird")
    //asumo que el formato es siempre YYYY-MM-DD y podemos comparar posteriormente fechas
    @NotBlank(message = "La fecha no puede estar vacía!")
    private String dateOfBirth;


    @ManyToOne // muchos pacientes pueden ser atendidos por un mismo empleado
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_Id") // Clave foranea
    Employee admittedBy;

    public Patient() {
    }

    public Patient(String name, String dateOfBirth, Employee admittedBy) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", admittedBy=" + admittedBy +
                '}';
    }
}

