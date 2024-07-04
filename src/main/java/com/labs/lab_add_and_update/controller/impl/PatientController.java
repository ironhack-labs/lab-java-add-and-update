package com.labs.lab_add_and_update.controller.impl;

import com.labs.lab_add_and_update.controller.dto.UpdatePatientDTO;
import com.labs.lab_add_and_update.model.Patient;
import com.labs.lab_add_and_update.service.impl.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return  patientService.getAllPatients();
    }

    @GetMapping("/patient/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @GetMapping("/patientsByDoctorDepartment")
    public List<Patient> getPatientsByDoctorDepartment(@RequestParam String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patientsByDateOfBirth")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patientsByDoctorStatus")
    public List<Patient> getPatientsByDoctorStatus(@RequestParam String status) {
        return patientService.getPatientsByDoctorStatus(status);
    }

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PatchMapping("/patient/{patientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@RequestBody @Valid UpdatePatientDTO updatePatientDTO, @PathVariable Long patientId) {
        patientService.updatePatient(patientId, updatePatientDTO);
    }
}
