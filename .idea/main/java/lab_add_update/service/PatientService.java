package com.example.lab_add_update.service;

import com.example.lab_add_update.dto.PatientDTO;
import com.example.lab_add_update.model.Patient;
import com.example.lab_add_update.model.Doctor;
import com.example.lab_add_update.repository.PatientRepository;
import com.example.lab_add_update.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Patient addPatient(PatientDTO patientDTO) {
        Doctor doctor = doctorRepository.findById(patientDTO.getAdmittedBy())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = new Patient(patientDTO.getName(), patientDTO.getDateOfBirth(), doctor);
        return patientRepository.save(patient);
    }

    public void updatePatient(Long patientId, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(patientDTO.getAdmittedBy())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(doctor);

        patientRepository.save(patient);
    }
}
