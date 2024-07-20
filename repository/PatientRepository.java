package com.ironhack.week10lab.repository;

import com.ironhack.week10lab.model.EmployeeStatus;
import com.ironhack.week10lab.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(LocalDate dateOfBirth, LocalDate dateOfBirth2);

    List<Patient> findByAdmittedBy_Department(String admittedByDepartment);

    List<Patient> findByAdmittedBy_Status(EmployeeStatus status);

}
