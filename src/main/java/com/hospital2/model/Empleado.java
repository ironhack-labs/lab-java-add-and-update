package com.hospital2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDate;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "El departamento no puede estar vacío")
    private String departamento;

    @NotEmpty(message = "El estado no puede estar vacío")
    private String estado;
}
