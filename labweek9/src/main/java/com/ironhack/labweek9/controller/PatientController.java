package com.ironhack.labweek9.controller;

import com.ironhack.labweek9.model.Patient;
import com.ironhack.labweek9.model.PatientDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface PatientController {

    public Patient createPatient(Patient patient);
    public Patient updatePatient(Integer id, PatientDTO updatedPatient);
}
