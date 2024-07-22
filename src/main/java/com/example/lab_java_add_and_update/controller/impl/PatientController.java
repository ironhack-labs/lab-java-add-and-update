package com.example.lab_java_add_and_update.controller.impl;

import com.example.lab_java_add_and_update.controller.interfaces.IPatientController;
import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Patient;
import com.example.lab_java_add_and_update.repository.PatientRepository;
import com.example.lab_java_add_and_update.service.impl.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patient")

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientId(@PathVariable Integer id) {

        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @GetMapping("/patient/{dateOfBirth}")
    public List<Patient> getPatientByDateOfBirth(LocalDate dateOfBirth) {
        return patientRepository.findAllByDateOfBirth(dateOfBirth);
    }

    @GetMapping("/patient/{admittedBy}")
    public List<Patient> getPatientByAdmittedBy(Employee employee) {
        return patientRepository.findAllByAdmittedBy(employee);

    }
                                    //Post
    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody @Valid Patient patient) {
        PatientService.savePatient(patient);

   /*
    @GetMapping("patient/{statusoff}")
    public List<Patient> getPatientByStatus(String name, @RequestParam(defaultValue = "OFF") Status status){
        if (status.equals(Status.OFF)) return patientRepository.findAllPatientByStatusParms(name, status);
        return patientRepository.findAllByStatus(status);
    }

    @GetMapping("patient/{admittedBySamOrtega}")
    public List<Patient> getPatientByAdmittedBy(@RequestParam(defaultValue = "564134") Employee name) {
        return patientRepository.findAllByAdmittedBy(name);*/
    }
}
