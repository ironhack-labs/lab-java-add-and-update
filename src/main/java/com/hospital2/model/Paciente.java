package com.hospital2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDate;

@Entity
@Data
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Empleado admitidoPor;
}
