package com.hospital2;

import com.hospital2.enums.Status;
import com.hospital2.enums.Department;
import com.hospital2.model.Employee;
import com.hospital2.model.Patient;
import com.hospital2.repository.EmployeeRepository;
import com.hospital2.repository.PatientRepository;
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
        // Crear los empleados con los departamentos del enum Department
        Employee employee1 = new Employee();
        employee1.setDepartment(Department.CARDIOLOGY);
        employee1.setName("Alonso Flores");
        employee1.setStatus(Status.ON_CALL);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setDepartment(Department.IMMUNOLOGY);
        employee2.setName("Sam Ortega");
        employee2.setStatus(Status.ON);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setDepartment(Department.CARDIOLOGY);
        employee3.setName("German Ruiz");
        employee3.setStatus(Status.OFF);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setDepartment(Department.PULMONARY);
        employee4.setName("Maria Lin");
        employee4.setStatus(Status.ON);
        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setDepartment(Department.ORTHOPAEDIC);
        employee5.setName("Paolo Rodriguez");
        employee5.setStatus(Status.ON_CALL);
        employeeRepository.save(employee5);

        Employee employee6 = new Employee();
        employee6.setDepartment(Department.PSYCHIATRIC);
        employee6.setName("John Paul Armes");
        employee6.setStatus(Status.OFF);
        employeeRepository.save(employee6);

        // Crear los pacientes
        Patient patient1 = new Patient();
        patient1.setName("Jaime Jordan");
        patient1.setDateOfBirth(LocalDate.of(1984, 3, 2));
        patient1.setAdmittedBy(employee2); // admitted_by -> Sam Ortega
        patientRepository.save(patient1);

        Patient patient2 = new Patient();
        patient2.setName("Marian Garcia");
        patient2.setDateOfBirth(LocalDate.of(1972, 1, 12));
        patient2.setAdmittedBy(employee2); // admitted_by -> Sam Ortega
        patientRepository.save(patient2);

        Patient patient3 = new Patient();
        patient3.setName("Julia Dusterdieck");
        patient3.setDateOfBirth(LocalDate.of(1954, 6, 11));
        patient3.setAdmittedBy(employee1); // admitted_by -> Alonso Flores
        patientRepository.save(patient3);

        Patient patient4 = new Patient();
        patient4.setName("Steve McDuck");
        patient4.setDateOfBirth(LocalDate.of(1931, 11, 10));
        patient4.setAdmittedBy(employee3); // admitted_by -> German Ruiz
        patientRepository.save(patient4);

        Patient patient5 = new Patient();
        patient5.setName("Marian Garcia");
        patient5.setDateOfBirth(LocalDate.of(1999, 2, 15));
        patient5.setAdmittedBy(employee6); // admitted_by -> John Paul Armes
        patientRepository.save(patient5);

        System.out.println("Datos cargados exitosamente en la base de datos.");
    }
}
