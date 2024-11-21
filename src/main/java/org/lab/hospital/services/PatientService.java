package org.lab.hospital.services;



import org.lab.hospital.entities.Patient;
import org.lab.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findByDateOfBirthRange(String startDate, String endDate) {
        return patientRepository.findAll()
                .stream()
                .filter(patient -> patient.getDateOfBirth().compareTo(startDate) >= 0 &&
                        patient.getDateOfBirth().compareTo(endDate) <= 0)
                .toList();
    }
}
