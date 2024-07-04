package java_spring_lab.crud.service.interfaces;

import java_spring_lab.crud.model.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> getAllPatients();
    Patient getPatientById(Integer id);
    void savePatient(Patient patient);

    void updatePatientInformation(Patient patient, Integer id);
}
