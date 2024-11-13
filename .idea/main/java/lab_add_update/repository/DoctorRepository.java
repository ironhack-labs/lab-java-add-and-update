package com.example.lab_add_update.repository;

import com.example.lab_add_update.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmployeeId(Long employeeId);
}
