package com.ironhack.week_10_lab.repository;


import com.ironhack.week_10_lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
