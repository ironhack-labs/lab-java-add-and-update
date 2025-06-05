@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Patient addPatient(@RequestBody Patient p) {
        return patientRepository.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient updated) {
        Patient p = patientRepository.findById(id).orElseThrow();
        p.setName(updated.getName());
        p.setDateOfBirth(updated.getDateOfBirth());
        p.setAdmittedBy(updated.getAdmittedBy());
        return ResponseEntity.ok(patientRepository.save(p));
    }
}
