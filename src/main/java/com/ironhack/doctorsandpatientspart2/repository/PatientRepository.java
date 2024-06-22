package com.ironhack.doctorsandpatientspart2.repository;

import com.ironhack.doctorsandpatientspart2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
