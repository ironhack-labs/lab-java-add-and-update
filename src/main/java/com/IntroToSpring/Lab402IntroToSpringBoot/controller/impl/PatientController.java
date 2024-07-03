package com.IntroToSpring.Lab402IntroToSpringBoot.controller.impl;

import com.IntroToSpring.Lab402IntroToSpringBoot.model.Patient;
import com.IntroToSpring.Lab402IntroToSpringBoot.repository.PatientRepository;
import com.IntroToSpring.Lab402IntroToSpringBoot.service.interfaces.IPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController{
//    @Autowired
//    private PatientRepository patientRepository;

    @Autowired
    IPatientService patientService;

    //    ********************************************* GET *********************************************

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/doctor/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patients/doctor/status/off")
    public List<Patient> getPatientsByDoctorStatusOff() {
        return patientService.getPatientsByDoctorStatusOff();
    }

    //    ********************************************* POST *********************************************

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody @Valid Patient patient) {
        patientService.savePatient(patient);
    }

    //    ********************************************* PUT *********************************************

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable Long id, @RequestBody @Valid Patient patient) {
        patientService.updatePatient(id, patient);
    }

}
