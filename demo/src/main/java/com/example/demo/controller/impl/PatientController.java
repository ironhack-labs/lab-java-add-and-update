package com.example.demo.controller.impl;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.imlp.EmployeeService;
import com.example.demo.service.imlp.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @PostMapping("/patients")
    public void createPatient(@RequestBody Patient patient){
        patientService.createPatient(patient);
    }

    @PutMapping("/patients/{id}")
    public void updateDepartmentDoctor(@PathVariable Integer id, @RequestBody Patient patient) {
        patientService.updatePatient(id,patient);
    }

}
