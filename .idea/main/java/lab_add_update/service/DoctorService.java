package com.example.lab_add_update.service;

import com.example.lab_add_update.dto.DoctorDTO;
import com.example.lab_add_update.model.Doctor;
import com.example.lab_add_update.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(doctorDTO.getDepartment(), doctorDTO.getName(), doctorDTO.getStatus());
        return doctorRepository.save(doctor);
    }

    public void changeDoctorStatus(Long employeeId, String status) {
        Doctor doctor = doctorRepository.findByEmployeeId(employeeId);
        if (doctor != null) {
            doctor.setStatus(status);
            doctorRepository.save(doctor);
        }
    }

    public void updateDepartment(Long employeeId, String department) {
        Doctor doctor = doctorRepository.findByEmployeeId(employeeId);
        if (doctor != null) {
            doctor.setDepartment(department);
            doctorRepository.save(doctor);
        }
    }

    public void changeStatus(Long employeeId, String status) {
        Doctor doctor = doctorRepository.findByEmployeeId(employeeId);
        if (doctor != null) {
            doctor.setStatus(status);
            doctorRepository.save(doctor);
        }
    }
}