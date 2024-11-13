package com.example.lab_add_update.controller;

import com.example.lab_add_update.dto.PatientDTO;
import com.example.lab_add_update.model.Patient;
import com.example.lab_add_update.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient addPatient(@RequestBody PatientDTO patientDTO) {
        return patientService.addPatient(patientDTO);
    }

    @PutMapping("/{patientId}")
    public void updatePatient(@PathVariable Long patientId, @RequestBody PatientDTO patientDTO) {
        patientService.updatePatient(patientId, patientDTO);
    }
}
