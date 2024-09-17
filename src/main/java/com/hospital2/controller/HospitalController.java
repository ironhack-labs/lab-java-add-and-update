package com.hospital2.controller;

import com.hospital2.model.Empleado;
import com.hospital2.model.Paciente;
import com.hospital2.service.EmpleadoService;
import com.hospital2.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EmpleadoService empleadoService;

    // 1. Agregar nuevo paciente
    @PostMapping("/pacientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente agregarPaciente(@Valid @RequestBody Paciente paciente) {
        return pacienteService.agregarPaciente(paciente);
    }

    // 2. Agregar nuevo médico
    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado agregarEmpleado(@Valid @RequestBody Empleado empleado) {
        return empleadoService.agregarMedico(empleado);
    }

    // 3. Cambiar el estado de un médico
    @PatchMapping("/medicos/{id}/estado")
    public Empleado cambiarEstadoMedico(@PathVariable Long id, @RequestBody String nuevoEstado) {
        return empleadoService.actualizarEstadoMedico(id, nuevoEstado);
    }

    // 4. Actualizar el departamento de un médico
    @PatchMapping("/medicos/{id}/departamento")
    public Empleado actualizarDepartamentoMedico(@PathVariable Long id, @RequestBody String nuevoDepartamento) {
        return empleadoService.actualizarDepartamentoMedico(id, nuevoDepartamento);
    }

    // 5. Actualizar información del paciente
    @PutMapping("/pacientes/{id}")
    public Paciente actualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente pacienteActualizado) {
        return pacienteService.actualizarPaciente(id, pacienteActualizado);
    }
}
