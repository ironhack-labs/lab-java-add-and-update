package com.labs.lab_add_and_update.service.impl;

import com.labs.lab_add_and_update.controller.dto.UpdatePatientDTO;
import com.labs.lab_add_and_update.model.Patient;
import com.labs.lab_add_and_update.repository.PatientRepository;
import com.labs.lab_add_and_update.service.interfaces.IPatientService;
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
    public Patient getPatientById(Long patientId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @Override
    public List<Patient> getPatientsByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @Override
    public List<Patient> getPatientsByDateOfBirthRange(LocalDate startDate, LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByDoctorStatus(String status) {
        return patientRepository.findByAdmittedByStatus(status);
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Long patientId, UpdatePatientDTO updatePatientDTO) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty()) {
            return;
        }
        Patient existingPatient = patientOptional.get();
        if (updatePatientDTO.getName() != null) {
            existingPatient.setName(updatePatientDTO.getName());
        }
        if (updatePatientDTO.getDateOfBirth() != null) {
            existingPatient.setDateOfBirth(updatePatientDTO.getDateOfBirth());
        }
        if (updatePatientDTO.getAdmittedBy() != null) {
            existingPatient.setAdmittedBy(updatePatientDTO.getAdmittedBy());
        }
        patientRepository.save(existingPatient);
    }
}
