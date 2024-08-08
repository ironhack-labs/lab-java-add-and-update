package com.ironhack.week_10_lab.controller;



import com.ironhack.week_10_lab.model.Employee;
import com.ironhack.week_10_lab.model.Patient;
import com.ironhack.week_10_lab.service.EmployeeService;
import com.ironhack.week_10_lab.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        Patient patient = patientService.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        if (updates.containsKey("name")) {
            patient.setName((String) updates.get("name"));
        }
        if (updates.containsKey("date_of_birth")) {
            patient.setDateOfBirth(java.time.LocalDate.parse((String) updates.get("date_of_birth")));
        }
        if (updates.containsKey("admitted_by")) {
            Employee doctor = employeeService.findById((Integer) updates.get("admitted_by"))
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            patient.setAdmittedBy(doctor);
        }
        patientService.save(patient);
        return ResponseEntity.ok(patient);
    }
}



