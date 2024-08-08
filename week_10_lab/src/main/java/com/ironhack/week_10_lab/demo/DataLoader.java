package com.ironhack.week_10_lab.demo;

import com.ironhack.week_10_lab.model.Employee;
import com.ironhack.week_10_lab.model.Patient;
import com.ironhack.week_10_lab.repository.EmployeeRepository;
import com.ironhack.week_10_lab.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        // Adding employees
        Employee emp1 = new Employee(356712, "cardiology", "Alonso Flores", Employee.Status.ON_CALL);
        Employee emp2 = new Employee(564134, "immunology", "Sam Ortega", Employee.Status.ON);
        Employee emp3 = new Employee(761527, "cardiology", "German Ruiz", Employee.Status.OFF);
        Employee emp4 = new Employee(166552, "pulmonary", "Maria Lin", Employee.Status.ON);
        Employee emp5 = new Employee(156545, "orthopaedic", "Paolo Rodriguez", Employee.Status.ON_CALL);
        Employee emp6 = new Employee(172456, "psychiatric", "John Paul Armes", Employee.Status.OFF);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);
        employeeRepository.save(emp5);
        employeeRepository.save(emp6);

        // Adding patients
        Patient patient1 = new Patient(0, "Jaime Jordan", LocalDate.of(1984, 3, 2), emp2);
        Patient patient2 = new Patient(0, "Marian Garcia", LocalDate.of(1972, 1, 12), emp2);
        Patient patient3 = new Patient(0, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), emp1);
        Patient patient4 = new Patient(0, "Steve McDuck", LocalDate.of(1931, 11, 10), emp3);
        Patient patient5 = new Patient(0, "Marian Garcia", LocalDate.of(1999, 2, 15), emp6);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);
    }
}
