package com.ironhack.week10_lab.service;

import com.ironhack.week10_lab.model.Patient;
import com.ironhack.week10_lab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}

