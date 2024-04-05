package org.example.service;

import org.example.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPatientService {

    List<Patient> findAll();
    Optional<Patient> findById(Integer id);
    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);

    Optional<List<Patient>> findPatientsByEmployeeDepartment( @Param("department")String department);

    Optional<List<Patient>> findPatientsByEmployeeStatusOff();

    void updatePatient(Integer id, Patient patient);

    void save(Patient patient);
}
