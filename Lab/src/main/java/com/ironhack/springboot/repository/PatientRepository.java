package com.ironhack.springboot.repository;

import com.ironhack.springboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {


    //Add new patient: Create a route to add a new patient.
    Patient addPatient(Patient patient);

    void update(Patient patient);
}
