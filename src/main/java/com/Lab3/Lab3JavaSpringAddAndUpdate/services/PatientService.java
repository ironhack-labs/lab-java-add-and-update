package com.Lab3.Lab3JavaSpringAddAndUpdate.services;

import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Employee;
import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Lab3.Lab3JavaSpringAddAndUpdate.repositories.PatientRepository;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patient){
        if(patientRepository.existsById(id)){
            return Optional.of(patientRepository.save(patient));
        }
        return Optional.empty();
    }
}
