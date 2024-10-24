package com.activity.lab404.service;


import com.activity.lab404.model.Doctor;
import com.activity.lab404.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> changeDoctorStatus(Long id, String status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setStatus(status);
        return Optional.of(doctorRepository.save(doctor));
    }

    public Optional<Doctor> updateDepartment(Long id, String department) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setDepartment(department);
        return Optional.of(doctorRepository.save(doctor));
    }
}
