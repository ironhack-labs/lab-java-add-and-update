package com.IntroToSpring.Lab402IntroToSpringBoot.service.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.PatientRepository;
import com.IntroToSpring.Lab402IntroToSpringBoot.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @Override
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long id, Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return;
        patientRepository.save(patient);
    }
}
