package java_spring_lab.crud.controller.impl;

import java_spring_lab.crud.model.Patient;
import java_spring_lab.crud.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatientInformation(@RequestBody Patient patient, @PathVariable Integer id){
        patientService.updatePatientInformation(patient, id);
    }



}
