package com.ironhack.sprinkgweek10.repository;

import com.ironhack.sprinkgweek10.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
