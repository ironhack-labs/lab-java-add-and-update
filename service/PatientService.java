package com.ironhack.week10lab.service;

import com.ironhack.week10lab.model.Patient;
import com.ironhack.week10lab.repository.EmployeeRepository;
import com.ironhack.week10lab.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatientInformation(Patient updatedPatient) {
        Patient patient = patientRepository.findById(updatedPatient.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
        patient.setName(updatedPatient.getName());
        patient.setDateOfBirth(updatedPatient.getDateOfBirth());
        patient.setAdmittedBy(updatedPatient.getAdmittedBy());
        return patientRepository.save(updatedPatient);
    }


}
