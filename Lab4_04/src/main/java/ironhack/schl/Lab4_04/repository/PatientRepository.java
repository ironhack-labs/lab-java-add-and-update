package ironhack.schl.Lab4_04.repository;

import ironhack.schl.Lab4_04.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
