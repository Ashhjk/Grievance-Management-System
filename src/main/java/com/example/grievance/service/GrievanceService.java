package com.example.grievance.service;

import com.example.grievance.model.Grievance;
import com.example.grievance.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrievanceService {
    @Autowired
    private GrievanceRepository grievanceRepository;

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Grievance saveGrievance(Grievance grievance) {
        return grievanceRepository.save(grievance);
    }
}

