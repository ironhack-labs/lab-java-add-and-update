package com.Lab3.Lab3JavaSpringAddAndUpdate.model;

import com.Lab3.Lab3JavaSpringAddAndUpdate.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Data // ya me da getters y setters, constructor vacio y constructor lleno
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String department;
    private String name;
    @Setter
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

}
