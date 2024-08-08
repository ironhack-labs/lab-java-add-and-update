package com.ironhack.week_10_lab.service;


import com.ironhack.week_10_lab.model.Patient;
import com.ironhack.week_10_lab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findById(int id) {
        return patientRepository.findById(id);
    }

    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }
}
