package com.hospital2.service;

import com.hospital2.exception.ResourceNotFoundException;
import com.hospital2.model.Empleado;
import com.hospital2.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado agregarMedico(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizarEstadoMedico(Long id, String nuevoEstado) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setEstado(nuevoEstado);
                    return empleadoRepository.save(empleado);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Médico no encontrado"));
    }

    public Empleado actualizarDepartamentoMedico(Long id, String nuevoDepartamento) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setDepartamento(nuevoDepartamento);
                    return empleadoRepository.save(empleado);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Médico no encontrado"));
    }
}
