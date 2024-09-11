package com.example.grievance.repository;

import com.example.grievance.model.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {
}

