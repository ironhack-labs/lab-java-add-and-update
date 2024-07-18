package com.ironhack.doctorpatient.repository;

import com.ironhack.doctorpatient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}