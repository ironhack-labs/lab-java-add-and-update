package com.example.demo.services;

import com.example.demo.dtos.PatientPatchDTO;
import com.example.demo.models.Employee;
import com.example.demo.models.Patient;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //Add new patient

    public Patient createPatient (Patient patient) {
        return patientRepository.save(patient);
    }
    //Update patient information
    public Patient modifyPatient(int id, PatientPatchDTO patientDTO) {
        Patient existingPatient = patientRepository.findByPatientId(id);

        if (patientDTO.getName() != null) {
            existingPatient.setName(patientDTO.getName());
        }

        if (patientDTO.getDateOfBirth() != null) {
            existingPatient.setDateOfBirth(patientDTO.getDateOfBirth());
        }
        if (patientDTO.getAdmittedById() != null) {
            Employee newAdmittedBy = employeeRepository.findByEmployeeId(patientDTO.getAdmittedById());
            existingPatient.setAdmittedBy(newAdmittedBy);
        }
        return patientRepository.save(existingPatient);
    }
}
