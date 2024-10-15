package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.model.Status;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctorStatus(Long id, String status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setStatus(Status.valueOf(status.toUpperCase()));
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorDepartment(Long id, String department) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }
}
