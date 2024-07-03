package com.IntroToSpring.Lab402IntroToSpringBoot.service.interfaces;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPatientService {
    List<Patient> getAllPatients();

    Optional<Patient> getPatientById(Long id);

    List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate);

    List<Patient> getPatientsByDoctorDepartment(String department);

    List<Patient> getPatientsByDoctorStatusOff();

    void savePatient(Patient patient);

    void updatePatient(Long id, Patient patient);
}
