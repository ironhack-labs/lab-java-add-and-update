package com.ironhack.doctorpatient.service;

import com.ironhack.doctorpatient.model.Patient;
import com.ironhack.doctorpatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patient.setName(patientDetails.getName());
            patient.setDateOfBirth(patientDetails.getDateOfBirth());
            patient.setAdmittedBy(patientDetails.getAdmittedBy());
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Doctor not found");
        }
    }
}