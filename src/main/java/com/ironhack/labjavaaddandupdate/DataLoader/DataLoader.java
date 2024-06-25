package com.ironhack.labjavaaddandupdate.DataLoader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ironhack.labjavaaddandupdate.Repositories.EmployeesRepository;
import com.ironhack.labjavaaddandupdate.Repositories.PatientsRepository;
import com.ironhack.labjavaaddandupdate.JavaClass.Employees;
import com.ironhack.labjavaaddandupdate.JavaClass.Status;
import com.ironhack.labjavaaddandupdate.JavaClass.Patients;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeesRepository employeesRepository;
    private final PatientsRepository patientsRepository;

    public DataLoader(EmployeesRepository employeesRepository, PatientsRepository patientsRepository) {
        this.employeesRepository = employeesRepository;
        this.patientsRepository = patientsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedEmployees();
        seedPatients();
    }

    private void seedEmployees() {
        employeesRepository.save(new Employees(356712, "cardiology", "Alonso Flores", Status.ON_CALL));
        employeesRepository.save(new Employees(564134, "immunology", "Sam Ortega", Status.ON));
        employeesRepository.save(new Employees(761527, "cardiology", "German Ruiz", Status.OFF));
        employeesRepository.save(new Employees(166552, "pulmonary", "Maria Lin", Status.ON));
        employeesRepository.save(new Employees(156545, "orthopaedic", "Paolo Rodriguez", Status.ON_CALL));
        employeesRepository.save(new Employees(172456, "psychiatric", "John Paul Armes", Status.OFF));
    }

    private void seedPatients() {
        patientsRepository.save(new Patients(1, "Jaime Jordan", "1984-03-02", 564134));
        patientsRepository.save(new Patients(2, "Marian Garcia", "1972-01-12", 564134));
        patientsRepository.save(new Patients(3, "Julia Dusterdieck", "1954-06-11", 356712));
        patientsRepository.save(new Patients(4, "Steve McDuck", "1931-11-10", 761527));
        patientsRepository.save(new Patients(5, "Marian Garcia", "1999-02-15", 172456));
    }
}