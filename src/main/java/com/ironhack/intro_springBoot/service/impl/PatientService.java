package com.ironhack.intro_springBoot.service.impl;

import com.ironhack.intro_springBoot.model.Patient;
import com.ironhack.intro_springBoot.repository.PatientRepository;
import com.ironhack.intro_springBoot.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
    }

    @Override
    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByAdmittingDoctorDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @Override
    public List<Patient> getPatientsByAdmittingDoctorStatusOff(String off) {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }


}
