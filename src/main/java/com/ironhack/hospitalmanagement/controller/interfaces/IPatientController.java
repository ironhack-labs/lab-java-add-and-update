package com.ironhack.hospitalmanagement.controller.interfaces;

import com.ironhack.hospitalmanagement.model.Patient;
import java.time.LocalDate;
import java.util.List;

public interface IPatientController {
    public List<Patient> getAllPatients();
    public Patient getPatientById(Long id);
    public List<Patient> getPatientsByDateOfBirthRange(LocalDate start_date, LocalDate end_date);
    public List<Patient> getPatientsByAdmittingDoctorDepartment(String department);
    public List<Patient> getPatientsByAdmittingDoctorStatusOff();
}
