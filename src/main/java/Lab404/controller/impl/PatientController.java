package Lab404.controller.impl;


import Lab404.model.Employee;
import Lab404.model.EmployeeStatus;
import Lab404.model.Patient;
import Lab404.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }


    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department){
        return patientRepository.findAllPatientsByDoctorDepartment(department);
    }

    @GetMapping("/patients/doctorstatus/{employeeStatus}")
    public List<Patient> findAllPatientsByDoctorStatusOff(@PathVariable EmployeeStatus employeeStatus){
        return patientRepository.findAllPatientsByDoctorStatusOff(employeeStatus);
    }

    @PostMapping("/patients/new/")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient savePatient(@RequestBody @Valid Patient patient) {
        return patientRepository.save(patient);
    }


    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable Integer id, @RequestBody @Valid Patient updatedPatient) {
            Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        updatedPatient.setId(id);  // id Check
        return patientRepository.save(updatedPatient);
    }

}



