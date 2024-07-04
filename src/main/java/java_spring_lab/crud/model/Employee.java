package java_spring_lab.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
}
