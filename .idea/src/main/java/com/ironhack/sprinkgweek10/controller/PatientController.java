package com.ironhack.sprinkgweek10.controller;

import com.ironhack.sprinkgweek10.model.Patient;
import com.ironhack.sprinkgweek10.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patients")
@RestController
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return patientService.create(patient);
    }
    @PutMapping("/{id}")
    public void updatePatient(@PathVariable("id") int id, @RequestBody @Valid Patient patient) {
        patientService.updatePatient(id,patient);

    }
}
