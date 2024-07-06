package Week4Lab2.Lab4._4.Repository;

import Week4Lab2.Lab4._4.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
