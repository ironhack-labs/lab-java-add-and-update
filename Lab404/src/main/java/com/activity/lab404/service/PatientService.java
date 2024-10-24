package com.activity.lab404.service;


import com.activity.lab404.model.Patient;
import com.activity.lab404.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);

    }

    public Optional<Patient> updatePatient(Long id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(patientDetails.getName());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setDoctor(patientDetails.getDoctor());
        return Optional.of(patientRepository.save(patient));
    }
}
