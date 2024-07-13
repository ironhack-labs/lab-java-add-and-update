package com.ironhack.week10_lab.controller;

import com.ironhack.week10_lab.model.Patient;
import com.ironhack.week10_lab.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @RequestBody Patient patientDetails) {
        Optional<Patient> patientOpt = patientService.findPatientById(id);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            patient.setName(patientDetails.getName());
            patient.setDateOfBirth(patientDetails.getDateOfBirth());
            patient.setAdmittedBy(patientDetails.getAdmittedBy());
            final Patient updatedPatient = patientService.updatePatient(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


