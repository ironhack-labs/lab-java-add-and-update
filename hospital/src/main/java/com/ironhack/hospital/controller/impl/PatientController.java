package com.ironhack.hospital.controller.impl;

import com.ironhack.hospital.model.Patient;
import com.ironhack.hospital.controller.dto.PatientUpdateDTO;
import com.ironhack.hospital.model.Employee.Status;
import com.ironhack.hospital.service.interfaces.IPatientService;

import java.util.Date;
import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patient/birth/{startDate}/{endDate}")
    public List<Patient> getPatientsByDateOfBirth(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return patientService.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patient/by-department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patient/by-status/{status}")
    public List<Patient> getPatientsByDoctorStatus(@PathVariable Status status) {
        return patientService.findByAdmittedByStatus(status);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient savePatient(@RequestBody @Valid Patient patient) {
        return patientService.savePatient(patient);
    }

    @PatchMapping("/patients/{id}")
    public Patient updatePatient(
            @PathVariable Integer id,
            @RequestBody @Valid PatientUpdateDTO patientUpdateDTO) {
        return patientService.updatePatient(id, patientUpdateDTO);
    }
}