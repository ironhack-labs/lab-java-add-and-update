package org.lab.hospital;



import org.lab.hospital.entities.Employee;
import org.lab.hospital.entities.Patient;
import org.lab.hospital.repositories.EmployeeRepository;
import org.lab.hospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    public DataLoader(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed data for Employees
        Employee doctor1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Employee doctor2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
        Employee doctor3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");

        employeeRepository.saveAll(Arrays.asList(doctor1, doctor2, doctor3));

        // Seed data for Patients
        Patient patient1 = new Patient(1L, "Jaime Jordan", "1984-03-02", doctor2);
        Patient patient2 = new Patient(2L, "Marian Garcia", "1972-01-12", doctor2);

        patientRepository.saveAll(Arrays.asList(patient1, patient2));
    }
}
