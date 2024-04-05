package org.example.controler;

import org.example.model.Patient;
import org.example.service.IEmployeeService;
import org.example.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients() {
        return patientService.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable(name="id") Integer patientID) {
        return patientService.findById(patientID).get();
    }
    @GetMapping("/patients/date_of_birth_range")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getByBirthdateRange(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate ,
                                             @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){

        return patientService.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patients/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable(name="department") String department) {
        return patientService.findPatientsByEmployeeDepartment(department).get();
    }

    @GetMapping("/patients/status/off")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByStatusOff() {
        return patientService.findPatientsByEmployeeStatusOff().get();
    }


    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Patient patient) {
        patientService.save(patient);
    }

    @PatchMapping("/patient/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable Integer id, @RequestBody Patient patient) {
        patientService.updatePatient(id, patient);
    }
}
