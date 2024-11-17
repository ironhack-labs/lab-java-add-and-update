package com.example.labweek8.Controller;

import com.example.labweek8.DTO.PatientDTO;
import com.example.labweek8.Model.Patient;
import com.example.labweek8.Repository.PatientRepository;
import com.example.labweek8.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patients")
@RequiredArgsConstructor
public class PatientControllermpl implements PatientController {

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
