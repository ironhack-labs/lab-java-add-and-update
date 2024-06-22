package com.ironhack.sprinkgweek10.demo;

import com.ironhack.sprinkgweek10.model.Employee;
import com.ironhack.sprinkgweek10.model.Patient;
import com.ironhack.sprinkgweek10.model.Status;
import com.ironhack.sprinkgweek10.repository.EmployeeRepository;
import com.ironhack.sprinkgweek10.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
@RequiredArgsConstructor
public class dataloader implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {
        Employee employee1 = new Employee(356712,"Alonso Flores","cardiology", Status.ON_CALL);
        Employee employee2 = new Employee(564134,"Sam Ortega","immunology", Status.ON);
        Employee employee3 = new Employee(761527,"German Ruiz","cardiology", Status.OFF);
        Employee employee4 =  new Employee(166552,"Maria Lin","pulmonary", Status.ON);
        Employee employee5 = new Employee(156545,"Paolo Rodriguez","orthopaedic", Status.ON_CALL);
        Employee employee6 = new Employee(172456,"John Paul Armes","psychiatric", Status.OFF);
        var listOfEmployees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        employeeRepository.saveAll(listOfEmployees);




        Patient patient1 = new Patient("Jaime Jordan", LocalDate.of(1984,3,2),employee2);
        Patient patient2 = new Patient("Marian Garcia", LocalDate.of(1972,1,12),employee2);
        Patient patient3 = new Patient("Julia Dusterdieck", LocalDate.of(1954,6,11),employee1);
        Patient patient4 = new Patient("Steve McDuck", LocalDate.of(1931,11,10),employee3);
        Patient patient5 = new Patient("Marian Garcia", LocalDate.of(1999,2,15),employee6);
        var listOfPatients = List.of(patient1, patient2, patient3, patient4, patient5);
        patientRepository.saveAll(listOfPatients);

    }
}
