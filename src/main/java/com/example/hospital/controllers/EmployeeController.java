@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addDoctor(@RequestBody Employee doctor) {
        return employeeRepository.save(doctor);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusMap) {
        Employee e = employeeRepository.findById(id).orElseThrow();
        e.setStatus(EmployeeStatus.valueOf(statusMap.get("status")));
        return ResponseEntity.ok(employeeRepository.save(e));
    }

    @PatchMapping("/{id}/department")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody Map<String, String> dept) {
        Employee e = employeeRepository.findById(id).orElseThrow();
        e.setDepartment(dept.get("department"));
        return ResponseEntity.ok(employeeRepository.save(e));
    }
}

