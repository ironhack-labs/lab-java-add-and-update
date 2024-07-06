package Week4Lab2.Lab4._4.Controller;


import Week4Lab2.Lab4._4.Model.Employee;
import Week4Lab2.Lab4._4.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/doctors")
    public class EmployeeController {
        @Autowired
        private EmployeeRepository employeeRepository;

        @PostMapping
        public Employee addEmployee(@RequestBody Employee employee) {
            return employeeRepository.addEmployee(employee);
        }

        @PutMapping("/{id}/status")
        public Employee updateEmployeeStatus(@PathVariable Integer id, @RequestBody String status) {
            return employeeRepository.updateEmployeeStatus(id, status);
        }

        @PutMapping("/{id}/department")
        public Employee updateEmployeeDepartment(@PathVariable Integer id, @RequestBody String department) {
            return employeeRepository.updateEmployeeDepartment(id, department);
        }
    }
