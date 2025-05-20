package com.ironhack.Lab404AddandUpdate.service.interfaces;

import com.ironhack.Lab404AddandUpdate.model.EmployeeStatus;
import com.ironhack.Lab404AddandUpdate.model.Patient;

import java.util.Date;
import java.util.List;

public interface IPatientService {
    Patient savePatient(Patient patient);


    List<Patient> getAllPatient();

    Patient getPatientById(Long id);


    List<Patient> findPatientsByDateOfBirthRange(Date start, Date end);


    List<Patient> findByEmployeeId_Department(String department);


    List<Patient> findByEmployeeId_Status(EmployeeStatus status);

    Patient updatePatient(Long id, Patient updatedPatient);
}
