package com.ironhack.doctorpatient.service;

import com.ironhack.doctorpatient.model.Doctor;
import com.ironhack.doctorpatient.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public Doctor updateDoctorStatus(Long id, String status) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.setStatus(status);
            return doctorRepository.save(doctor);
        }
        return null;
    }


    public Doctor updateDoctorDepartment(Long id, String department) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            doctor.setDepartment(department);
            return doctorRepository.save(doctor);
        }
        return null;
    }
}