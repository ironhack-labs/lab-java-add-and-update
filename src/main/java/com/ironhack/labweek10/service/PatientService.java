package com.ironhack.labweek10.service;

import com.ironhack.labweek10.model.Patient;
import com.ironhack.labweek10.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    //Add a single patient
    public Plant addPlant(Plant plant) {
        log.info("Adding new plant{}", plant);
        return plantRepository.save(plant);
    }
