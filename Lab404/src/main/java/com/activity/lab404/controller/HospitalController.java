package com.activity.lab404.controller;


import com.activity.lab404.model.Doctor;
import com.activity.lab404.model.Patient;
import com.activity.lab404.service.DoctorService;
import com.activity.lab404.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);

    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @PutMapping("/docotrs/{employeeId}/status")
    public ResponseEntity <Doctor> changeDoctorStatus(@PathVariable Long employeeId, @RequestParam String status) {
        return ResponseEntity.of(doctorService.changeDoctorStatus(employeeId, status));


    }

    @PutMapping("/doctors/{employeeId}/department")
    public ResponseEntity<Doctor> updateDoctorDepartment(@PathVariable Long employeeId, @RequestParam String department) {
        return ResponseEntity.of(doctorService.updateDepartment(employeeId, department));
    }

    @PutMapping("/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody Patient patientDetails) {
        return ResponseEntity.of(patientService.updatePatient(patientId, patientDetails));
    }
}


