package com.ironhack.Lab404AddandUpdate.repository;

import com.ironhack.Lab404AddandUpdate.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // here custom methods if I need them

}
