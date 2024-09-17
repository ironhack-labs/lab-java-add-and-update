package com.hospital2.repository;

import com.hospital2.model.Empleado;
import com.hospital2.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
