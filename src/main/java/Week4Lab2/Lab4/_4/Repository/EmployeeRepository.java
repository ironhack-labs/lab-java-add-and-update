package Week4Lab2.Lab4._4.Repository;



import Week4Lab2.Lab4._4.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeRepository, Integer> {


    Employee addEmployee(Employee employee);

    Employee updateEmployeeStatus(Integer id, String status);

    Employee updateEmployeeDepartment(Integer id, String department);
}
