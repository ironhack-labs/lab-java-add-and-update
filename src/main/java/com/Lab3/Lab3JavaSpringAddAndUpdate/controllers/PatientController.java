package com.Lab3.Lab3JavaSpringAddAndUpdate.controllers;


import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Employee;
import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Lab3.Lab3JavaSpringAddAndUpdate.services.PatientService;

import java.util.Optional;



@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    //add doctor
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){ return patientService.createPatient(patient);}

    //update patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        Optional<Patient> updatePatient = patientService.updatePatient(id, patient);
        return updatePatient.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

}
