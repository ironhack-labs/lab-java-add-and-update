package com.ironhack.doctorpatient.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long employeeId;

    @NotNull
    private String department;

    @NonNull
    private String name;

    @NonNull
    private String Status;

    public Doctor(String department, String name, String status) {
        this.department = department;
        this.name = name;
        Status = status;
    }

    public Doctor() {

    }
}
