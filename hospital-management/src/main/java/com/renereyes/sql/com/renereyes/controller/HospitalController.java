package com.renereyes.hospital.controller;

import com.renereyes.hospital.model.Employee;
import com.renereyes.hospital.model.Patient;
import com.renereyes.hospital.repository.EmployeeRepository;
import com.renereyes.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HospitalController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Add new patient
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // Add new doctor
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Change doctor status
    @PutMapping("/employees/{id}/status")
    public ResponseEntity<Employee> changeDoctorStatus(@PathVariable int id, @RequestBody String status) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setStatus(status);
            employeeRepository.save(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update doctor's department
    @PutMapping("/employees/{id}/department")
    public ResponseEntity<Employee> updateDoctorDepartment(@PathVariable int id, @RequestBody String department) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setDepartment(department);
            employeeRepository.save(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update patient information
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient updatedPatient) {
        Optional<Patient> patientOpt = patientRepository.findById(id);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            patient.setName(updatedPatient.getName());
            patient.setDateOfBirth(updatedPatient.getDateOfBirth());
            patient.setAdmittedBy(updatedPatient.getAdmittedBy());
            patientRepository.save(patient);
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
