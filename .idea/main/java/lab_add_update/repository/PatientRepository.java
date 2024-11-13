package com.example.lab_add_update.repository;

import com.example.lab_add_update.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}