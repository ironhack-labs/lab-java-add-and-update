package com.example.hospital.repositories;

import com.example.hospital.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // También puedes añadir búsquedas personalizadas aquí
}
