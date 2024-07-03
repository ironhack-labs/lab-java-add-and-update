package com.ironhack.intro_springBoot.controller.impl;


import com.ironhack.intro_springBoot.controller.interfaces.IPatientController;
import com.ironhack.intro_springBoot.model.Patient;
import com.ironhack.intro_springBoot.repository.PatientRepository;
import com.ironhack.intro_springBoot.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return patientService.getPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/doctor/department/{department}")
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/patients/doctor/status/off")
    public List<Patient> getPatientsByAdmittingDoctorStatusOff() {
        return patientService.getPatientsByAdmittingDoctorStatusOff("OFF");
    }

}
