package com.ironhack.labjavaaddandupdate.Controller;

import com.ironhack.labjavaaddandupdate.DTO.PatientDTO;
import com.ironhack.labjavaaddandupdate.DTO.UpdatePatientDTO;
import com.ironhack.labjavaaddandupdate.JavaClass.Patients;
import com.ironhack.labjavaaddandupdate.Repositories.PatientsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patients")

public class PatientController {

    @Autowired
    private PatientsRepository patientsRepository;

    @PostMapping
    public ResponseEntity<Patients> addNewPatient(@RequestBody @Valid PatientDTO patientDTO) {
        Patients patient = new Patients();
        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setAdmittedBy(patientDTO.getAdmittedBy());

        Patients savedPatient = patientsRepository.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    //Create a route to update patient information (the user should be able to update any patient information through this route).
    @PutMapping("/{id}")
    public ResponseEntity<Patients> updatePatient(@PathVariable Integer id, @RequestBody @Valid UpdatePatientDTO updatePatientDTO) {
        Optional<Patients> patientOptional = patientsRepository.findById(id);

        if (patientOptional.isPresent()) {
            Patients patient = patientOptional.get();
            patient.setName(updatePatientDTO.getName());
            patient.setDateOfBirth(updatePatientDTO.getDateOfBirth());
            patient.setAdmittedBy(updatePatientDTO.getAdmittedBy());
            Patients updatedPatient = patientsRepository.save(patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
