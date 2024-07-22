package com.example.lab_java_add_and_update.repository;

import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findById(Integer id);
    List<Patient> findAllByDateOfBirth(LocalDate dateOfBirth);
    List<Patient> findAllByName(String name);
    List<Patient> findAllByAdmittedBy(Employee admittedBy);

    List<Patient> findAll();
    //List<Patient> findAllByStatus(Status status);
}
