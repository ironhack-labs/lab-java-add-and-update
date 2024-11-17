package com.example.labweek8.Service;

import com.example.labweek8.DTO.PatientDTO;
import com.example.labweek8.Model.Employee;
import com.example.labweek8.Model.Patient;
import com.example.labweek8.Repository.EmployeeRepository;
import com.example.labweek8.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class PatientService {
    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient update(Long id, PatientDTO updatedPatient) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if( updatedPatient == null ) {
            return null;
        }
        Employee employee = employeeRepository.findById(updatedPatient.getDoctor()).orElse(null);
        if( employee == null ) {
            return null;
        } else patient.setDoctor(employee);

        String name = updatedPatient.getName();
        if ( name != null || !name.equals("")) {
            patient.setPatientName(name) ;
        }

        LocalDate dateOfBirth = updatedPatient.getDateOfBirth();
        if( dateOfBirth != null ) {
            patient.setDateOfBirth(dateOfBirth);
        }
        return patientRepository.save(patient);
    }