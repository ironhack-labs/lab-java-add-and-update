package com.example.lab_java_add_and_update;

import com.example.lab_java_add_and_update.model.Employee;
import com.example.lab_java_add_and_update.model.Patient;
import com.example.lab_java_add_and_update.model.Status;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LabJavaAddAndUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabJavaAddAndUpdateApplication.class, args);
	}

	Employee employee1 = new Employee (356712, "cardiology", "Alonso Flores", Status.ON_OFF);
	Employee employee2 = new Employee (564134, "immunology", "Sam Ortega", Status.ON);
	Employee employee3 = new Employee (761527, "cardiology", "Germain Ruiz", Status.OFF);
	Employee employee4 = new Employee (166552, "pulmonary", "Maria Lin", Status.ON);
	Employee employee5 = new Employee (156545, "orthopaedic", "Paolo Rodriguez", Status.ON_OFF);
	Employee employee6 = new Employee (172456, "psychiatric", "John Paul Armes", Status.ON);

	Patient patient1 = new Patient(1, "Jaime Jordan", LocalDate.of(1984,02,03), employee2);
	Patient patient2 = new Patient(2, "Marian Garcia", LocalDate.of(1972,01,12), employee2);
	Patient patient3 = new Patient(3, "Julia Dusterdieck", LocalDate.of(1954,06,11), employee1);
	Patient patient4 = new Patient(4, "Steve McDuck", LocalDate.of(1931,11,10), employee3);
	Patient patient5 = new Patient(5, "Marian Garcia", LocalDate.of(1999,02,15),employee6);


}
