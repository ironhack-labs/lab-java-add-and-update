package com.example.hospital.repositories;

import com.example.hospital.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Puedes añadir métodos personalizados aquí si lo necesitas más adelante
}
