package com.ironhack.labjavaaddandupdate.Repositories;

import com.ironhack.labjavaaddandupdate.JavaClass.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {
}