package com.example.demo.controllers;

import com.example.demo.models.Patients;
import com.example.demo.repositories.PatientsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/Patients")
public class PatientsController {
    @Autowired
    PatientsRepository patientsRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatients(@RequestBody Patients patients) {
        patientsRepository.save(patients);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInfoPatient (@PathVariable int id, @RequestBody @Valid Patients patients){
        Patients existingPatients = patientsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingPatients.setName(patients.getName());

        patientsRepository.save(existingPatients);
    }

}
