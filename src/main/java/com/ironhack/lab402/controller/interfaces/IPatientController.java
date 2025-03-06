package com.ironhack.lab402.controller.interfaces;

import com.ironhack.lab402.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface IPatientController {

    List<Patient> getAllPatients();

    Patient getPatientById(Integer patientID);

    List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate);

    List<Patient> getPatientsByDoctorDepartment(String department);

    List<Patient> getPatientsByDoctorStatusOff();

    // ************************** LAB 4.04 **************************

    void savePatient(Patient patient);

    void updatePatient(Patient patient, Integer patientId);

}
