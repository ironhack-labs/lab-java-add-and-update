package com.example.demo.Service.Interfaces;

import com.example.demo.DTO.PatientUpdateDTO;
import com.example.demo.Model.Patient;

public interface IPatientService {
    void savePatient(Patient patient);

    Patient updatePatient(Long id, PatientUpdateDTO dto);
}
