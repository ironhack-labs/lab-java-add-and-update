package Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
EmployeeRepository employeeRepository;

    @Test
    public void findAll_employees_employeesList(){
        employeeRepository.findAll();
        List<Employee> employeeList = employeeRepository.findAll();
        System.out.println(employeeList);
        assertEquals(4,employeeList.size());
    }

}