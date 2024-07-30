package com.ironhack.labweek10.repository;

import com.ironhack.labweek10.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
