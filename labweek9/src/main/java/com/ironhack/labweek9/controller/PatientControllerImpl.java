package com.ironhack.labweek9.controller;

import com.ironhack.labweek9.model.Patient;
import com.ironhack.labweek9.model.PatientDTO;
import com.ironhack.labweek9.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientControllerImpl implements PatientController {

    private final PatientService patientService;

    @Override
    @PostMapping("post")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @Override
    @PatchMapping("/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody PatientDTO updatedPatient) {
        return patientService.update(id, updatedPatient);
    }
}
