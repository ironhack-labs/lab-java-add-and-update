package com.ironhack.labweek9.service;

import com.ironhack.labweek9.model.Employee;
import com.ironhack.labweek9.model.Patient;
import com.ironhack.labweek9.model.PatientDTO;
import com.ironhack.labweek9.repository.EmployeeRepository;
import com.ironhack.labweek9.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final EmployeeRepository employeeRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Integer id, PatientDTO updatedPatient) {
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
            patient.setName(name);
        }

        LocalDate dateOfBirth = updatedPatient.getDateOfBirth();
        if( dateOfBirth != null ) {
            patient.setDateOfBirth(dateOfBirth);
        }
        return patientRepository.save(patient);
    }
}
