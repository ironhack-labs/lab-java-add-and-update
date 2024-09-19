package com.Lab3.Lab3JavaSpringAddAndUpdate.repositories;

import com.Lab3.Lab3JavaSpringAddAndUpdate.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

