package com.ironhack.addupdate.repositories;

import com.ironhack.addupdate.models.Department;
import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDateOfBirthBetween(String startDate, String endDate);

    List<Patient> getPatientByAdmittedBy_Department(Department admittedByDepartment);

    List<Patient> getPatientByAdmittedBy_(Employee admittedBy);

    List<Patient> admittedBy(Employee admittedBy);

}

