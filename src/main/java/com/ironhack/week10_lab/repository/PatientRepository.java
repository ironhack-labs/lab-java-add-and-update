package com.ironhack.week10_lab.repository;

import com.ironhack.week10_lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}


