package com.example.demo.Controller.implem;

import com.example.demo.DTO.PatientUpdateDTO;
import com.example.demo.Model.Patient;

import com.example.demo.Service.Interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PatientController {

    @Autowired
    IPatientService patientService;

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(Patient patient){patientService.savePatient(patient);
    }


    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody PatientUpdateDTO dto) {
        return patientService.updatePatient(id, dto);
    }

}
