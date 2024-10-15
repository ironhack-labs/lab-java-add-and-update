package com.example.hospital.controller;

import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PatchMapping("/{id}/status")
    public Doctor updateDoctorStatus(@PathVariable Long id, @RequestParam String status) {
        return doctorService.updateDoctorStatus(id, status);
    }

    @PatchMapping("/{id}/department")
    public Doctor updateDoctorDepartment(@PathVariable Long id, @RequestParam String department) {
        return doctorService.updateDoctorDepartment(id, department);
    }
}
