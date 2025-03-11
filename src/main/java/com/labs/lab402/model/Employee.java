package com.labs.lab402.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Employee {
        @Id
        private Integer employeeId;
        private String name;
        private String department;

        @Enumerated(EnumType.STRING)
        private STATUS status;

        @OneToMany(mappedBy = "employee")
        @JsonIgnore
        List<Patient> patientList;
}
