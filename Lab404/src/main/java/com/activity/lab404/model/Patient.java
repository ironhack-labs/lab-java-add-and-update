package com.activity.lab404.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "patients")
public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String dateOfBirth;


    @ManyToOne
    @JoinColumn(name = "amditted_by", referencedColumnName = "employeeId")
    private Doctor doctor;

}
