package com.example.lab_add_update.controller;
import com.example.lab_add_update.model.Doctor;
import com.example.lab_add_update.dto.DoctorDTO;
import com.example.lab_add_update.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.addDoctor(doctorDTO);
    }

    @PutMapping("/{employeeId}/status")
    public void changeDoctorStatus(@PathVariable Long employeeId, @RequestParam String status) {
        doctorService.changeStatus(employeeId, status);
    }

    @PutMapping("/{employeeId}/department")
    public void updateDoctorDepartment(@PathVariable Long employeeId, @RequestParam String department) {
        doctorService.updateDepartment(employeeId, department);
    }
}