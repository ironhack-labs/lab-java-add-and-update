package com.renereyes.hospital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Patient {
    @Id
    private int patientId;
    private String name;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;
}
