package com.labs.lab_add_and_update.service.interfaces;

import com.labs.lab_add_and_update.controller.dto.UpdatePatientDTO;
import com.labs.lab_add_and_update.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    List<Patient> getPatientsByDoctorDepartment(String department);
    List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate);
    List<Patient> getPatientsByDoctorStatus(String status);

    void addPatient(Patient patient);
    void updatePatient(Long patientId, UpdatePatientDTO updatePatientDTO);
}
