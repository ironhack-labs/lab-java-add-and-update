package com.example.demo.Service.implem;

import com.example.demo.DTO.PatientUpdateDTO;
import com.example.demo.Model.Employee;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.Interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void savePatient(Patient patient){
        patientRepository.save(patient);
    }


    public Patient updatePatient(Long id, PatientUpdateDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        if (dto.getName() != null) {
            patient.setName(dto.getName());
        }

        if (dto.getDateOfBirth() != null) {
            patient.setDateOfBirth(dto.getDateOfBirth());
        }

        if (dto.getAdmittedById() != null) {
            Employee employee = employeeRepository.findById(dto.getAdmittedById())
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + dto.getAdmittedById()));
            patient.setAdmittedBy(employee);
        }

        return patientRepository.save(patient);
    }

}
