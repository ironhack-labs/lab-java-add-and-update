package com.example.demo.service.imlp;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeStatus;
import com.example.demo.model.Patient;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PatientRepository patientRepository;

    public void createPatient(Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Integer id, Patient patient){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return;
        patient.setPatient_id(id);
        patientRepository.save(patient);
    }


}
