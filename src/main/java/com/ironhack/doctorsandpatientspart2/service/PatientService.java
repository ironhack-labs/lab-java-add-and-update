package com.ironhack.doctorsandpatientspart2.service;

import com.ironhack.doctorsandpatientspart2.model.Patient;
import com.ironhack.doctorsandpatientspart2.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientService {
    private final PatientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Transactional
    public Patient create(Patient patient) {
        log.info("Creating patient: " + patient);
        return patientRepository.save(patient);
    }
    @Transactional
    public void updatePatient(Patient patient) {
        log.info("Updating patient: " + patient);
        var patientToUpdate = patientRepository.findById(patient.getId()).orElseThrow();
        patientToUpdate.setBirthDate(patient.getBirthDate());
        patientToUpdate.setAdmitted_by(patient.getAdmitted_by());
        patientRepository.save(patient);
    }
}
