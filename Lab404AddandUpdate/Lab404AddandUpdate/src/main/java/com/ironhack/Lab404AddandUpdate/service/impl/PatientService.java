package com.ironhack.Lab404AddandUpdate.service.impl;

import com.ironhack.Lab404AddandUpdate.model.EmployeeStatus;
import com.ironhack.Lab404AddandUpdate.model.Patient;
import com.ironhack.Lab404AddandUpdate.repository.PatientRepository;
import com.ironhack.Lab404AddandUpdate.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient " + id + " not found");
        return patientOptional.get();
    }

    @Override
    public List<Patient> findPatientsByDateOfBirthRange(Date start, Date end) {
        return patientRepository.findByPatientDateOfBirthBetween(start, end);
    }

    @Override
    public List<Patient> findByEmployeeId_Department(String department) {
        return patientRepository.findByEmployeeId_Department(department);
    }

    @Override
    public List<Patient> findByEmployeeId_Status(EmployeeStatus status) {
        return patientRepository.findByEmployeeId_Status(status);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatientOptional = patientRepository.findById(id);
        if (existingPatientOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient " + id + " not found");

        Patient existingPatient = existingPatientOptional.get();

        existingPatient.setPatientName(updatedPatient.getPatientName());
        existingPatient.setPatientDateOfBirth(updatedPatient.getPatientDateOfBirth());
        existingPatient.setEmployeeId(updatedPatient.getEmployeeId());

        return patientRepository.save(existingPatient);
    }
}


