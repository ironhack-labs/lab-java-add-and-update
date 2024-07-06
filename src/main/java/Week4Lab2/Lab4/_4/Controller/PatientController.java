package Week4Lab2.Lab4._4.Controller;


import Week4Lab2.Lab4._4.Model.Employee;
import Week4Lab2.Lab4._4.Model.Patient;
import Week4Lab2.Lab4._4.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired

    private PatientRepository patientRepository;


    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatientInformation(@PathVariable Integer id , @RequestBody Patient patientDetails) { return null; }
    Optional<Patient> patientOpt = patientRepository.findById(id);



}

