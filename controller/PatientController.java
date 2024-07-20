package com.ironhack.week10lab.controller;

import com.ironhack.week10lab.model.Patient;
import com.ironhack.week10lab.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public Patient addNewPatient(@RequestBody Patient patient) {
        return patientService.addNewPatient(patient);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatientInformation(@PathVariable Integer patientId, @RequestBody Patient updatedPatient) {
        updatedPatient.setPatientId(patientId);
        return patientService.updatePatientInformation(updatedPatient);
    }


}
