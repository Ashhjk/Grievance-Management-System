package com.example.grievance.Service;

import com.example.grievance.Entity.Grievance;
import com.example.grievance.Repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrievanceService {

    @Autowired
    private GrievanceRepository grievanceRepository;
    public Grievance updateGrievance(String complaint_id, Grievance updatedGrievance) {
        // Set the complaint_id from the path variable to ensure the entity is updated correctly
        updatedGrievance.setComplaint_id(complaint_id);
        // Save the updated grievance. If it does not exist, it will throw an exception.
        return grievanceRepository.save(updatedGrievance);
    }
    public Grievance saveGrievance(Grievance grievance) {
        // Here you need to handle automatic generation of complaintId
        return grievanceRepository.save(grievance);
    }

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Optional<Grievance> getGrievanceById(String complaintId) {
        return grievanceRepository.findById(complaintId);
    }

    public void deleteGrievance(String complaintId) {
        grievanceRepository.deleteById(complaintId);
    }
}
