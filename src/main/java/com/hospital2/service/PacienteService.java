package com.hospital2.service;

import com.hospital2.model.Paciente;
import com.hospital2.repository.PacienteRepository;
import com.hospital2.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente agregarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Long id, Paciente pacienteActualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNombre(pacienteActualizado.getNombre());
                    paciente.setAdmitidoPor(pacienteActualizado.getAdmitidoPor());
                    return pacienteRepository.save(paciente);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con id: " + id));
    }
}
