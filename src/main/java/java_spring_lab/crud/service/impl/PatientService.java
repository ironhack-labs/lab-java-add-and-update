package java_spring_lab.crud.service.impl;

import java_spring_lab.crud.model.Patient;
import java_spring_lab.crud.repository.PatientRepository;
import java_spring_lab.crud.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatientInformation(Patient patient, Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return;
        patientRepository.save(patient);
    }
}
