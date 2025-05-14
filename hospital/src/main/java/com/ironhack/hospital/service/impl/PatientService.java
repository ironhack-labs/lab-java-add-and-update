package com.ironhack.hospital.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ironhack.hospital.controller.dto.PatientUpdateDTO;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.model.Patient;
import com.ironhack.hospital.repository.PatientRepository;
import com.ironhack.hospital.service.interfaces.IPatientService;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty())
            return null;
        return patientOptional.get();
    }

    @Override
    public List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> findByAdmittedByDepartment(String department) {
        List<Patient> patients = patientRepository.findByAdmittedByDepartment(department);
        return patients.isEmpty() ? null : patients;
    }

    @Override
    public List<Patient> findByAdmittedByStatus(Status status) {
        List<Patient> patients = patientRepository.findByAdmittedByStatus(status);
        return patients.isEmpty() ? null : patients;
    }

    @Override
    public Patient savePatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public Patient updatePatient(Integer id, PatientUpdateDTO patientUpdateDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));

        patient.setName(patientUpdateDTO.getName());
        patient.setDateOfBirth(patientUpdateDTO.getDateOfBirth());

        return patientRepository.save(patient);
    }
}