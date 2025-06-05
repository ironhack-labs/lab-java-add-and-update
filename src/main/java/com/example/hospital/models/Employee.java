@Entity
public class Employee {
    @Id
    private Long employeeId;

    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    // Getters, setters, constructores vacíos y con parámetros
}
