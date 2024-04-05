package org.example.service;

import org.example.model.Patient;
import org.example.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public Optional<List<Patient>> findPatientsByEmployeeDepartment(String department) {
        return patientRepository.findPatientsByEmployeeDepartment(department);
    }

    @Override
    public Optional<List<Patient>> findPatientsByEmployeeStatusOff() {
        return patientRepository.findPatientsByEmployeeStatusOff();
    }

    @Override
    public void updatePatient(Integer id, Patient patient) {
        patientRepository.findById(id).ifPresent(existingPatient -> {
            existingPatient.setName(patient.getName());
            existingPatient.setDateOfBirth(patient.getDateOfBirth());
            existingPatient.setAdmittedBy(patient.getAdmittedBy());
            patientRepository.save(existingPatient);
        });
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
}
