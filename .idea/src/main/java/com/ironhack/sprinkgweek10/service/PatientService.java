package com.ironhack.sprinkgweek10.service;

import com.ironhack.sprinkgweek10.model.Patient;
import com.ironhack.sprinkgweek10.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    //Add new patient: Create a route to add a new patient.
    @Transactional
    public Patient create(Patient patient) {
        log.info("Creating patient {}", patient);
        return patientRepository.save(patient);
    }

    //Update patient information: Create a route to update patient information
    // (the user should be able to update any patient information through this route).
    @Transactional
    public void updatePatient(int id,Patient patient) {
        log.info("Updating patient {}", patient);
        var patientToUpdate = patientRepository.findById(patient.getId()).orElseThrow();
        patientToUpdate.setName(patient.getName());
        patientToUpdate.setBirthDate(patient.getBirthDate());
        patientToUpdate.setAdmittedBy(patient.getAdmittedBy());
        patientRepository.save(patientToUpdate);

    }
}
