package com.ironhack.springboot.service;

import com.ironhack.springboot.model.Employee;
import com.ironhack.springboot.model.Patient;
import com.ironhack.springboot.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;


    //Add new patient: Create a route to add a new patient.
    public Patient addPatient(Patient patient) {
        log.info("Adding patient");
        return patientRepository.save(patient);
    }

    public void addPatient(Long patientId, String name, Date dateOfBirth, Employee admittingDoctorId) {
        log.info("Adding patient");
        Patient patient = new Patient(patientId, name, dateOfBirth, admittingDoctorId);
        patientRepository.save(patient);
    }

    public void updatePatient(Long patientId, String name, Date dateOfBirth, Employee admittingDoctorId) {
        log.info("Updating patient");
        Patient patient = new Patient(patientId, name, dateOfBirth, admittingDoctorId);
        patientRepository.update(patient);
    }
}
