package com.example.demo.controllers;

import com.example.demo.dtos.EmployeePatchDTO;
import com.example.demo.dtos.PatientPatchDTO;
import com.example.demo.models.Employee;
import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/{patientId}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable int patientId) {
        return patientRepository.findByPatientId(patientId);
    }

    @GetMapping("/born-between/{from}/{to}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateBetween(@PathVariable String from, @PathVariable String to) {
        return patientRepository.findByDateOfBirthBetween(from, to);
    }

    @GetMapping("/by-doctor-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @GetMapping("/by-doctors-with-status/OFF")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getDoctorsByStatusOff() {
        return patientRepository.findByAdmittedBy_Status("OFF");
    }
//Add new patient
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient cratePatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    //Update patient information

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)

    public Patient patchEmployee(@PathVariable int id,@RequestBody PatientPatchDTO patientDTO) {
        return patientService.modifyPatient(id, patientDTO);
    }

}
