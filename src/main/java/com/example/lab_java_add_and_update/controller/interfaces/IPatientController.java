package com.example.lab_java_add_and_update.controller.interfaces;

import com.example.lab_java_add_and_update.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPatientController {

    List<Patient> getAllPatient();
    Patient getPatientId(Integer id);
}
