package com.example.demo.repositories;

import com.example.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Override
    List<Patient> findAll();

    Patient findByPatientId(int patientId);

    List<Patient> findByDateOfBirthBetween(String from, String to);
    List<Patient> findByAdmittedBy_Department(String department);
    List<Patient> findByAdmittedBy_Status(String status);
    }
