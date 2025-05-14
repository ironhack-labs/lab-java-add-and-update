package com.ironhack.hospital.service.interfaces;

import java.util.Date;
import java.util.List;

import com.ironhack.hospital.controller.dto.PatientUpdateDTO;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.model.Patient;

public interface IPatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(Integer id);

    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);

    List<Patient> findByAdmittedByDepartment(String department);

    List<Patient> findByAdmittedByStatus(Status status);

    Patient savePatient(Patient patient);

    Patient updatePatient(Integer id, PatientUpdateDTO patientUpdateDTO);
}