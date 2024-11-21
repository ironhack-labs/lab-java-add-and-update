package org.lab.hospital.controllers;


import org.lab.hospital.entities.Patient;
import org.lab.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping("/dob-range")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam String startDate, @RequestParam String endDate) {
        return patientService.findByDateOfBirthRange(startDate, endDate);
    }
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Patient patient = patientService.findById(id).orElseThrow();

        // Update patient fields
        if (updatedPatient.getName() != null) patient.setName(updatedPatient.getName());
        if (updatedPatient.getDateOfBirth() != null) patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        if (updatedPatient.getAdmittingDoctor() != null) patient.setAdmittingDoctor(updatedPatient.getAdmittingDoctor());

        return patientService.save(patient);
    }

}
