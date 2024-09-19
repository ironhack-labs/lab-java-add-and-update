package com.hospital2.service;

import com.hospital2.model.Patient;
import com.hospital2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setAdmittedBy(updatedPatient.getAdmittedBy());
        return patientRepository.save(patient);
    }
}
