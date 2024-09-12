package com.example.grievance.Service;

import com.example.grievance.Entity.Assignment;
import com.example.grievance.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment updateAssignment(String complaint_id, Assignment updatedAssignment) {
        updatedAssignment.setComplaint_id(complaint_id); // Ensure the ID is set manually
        return assignmentRepository.save(updatedAssignment);
    }
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(String complaintId) {
        return assignmentRepository.findById(complaintId);
    }

    public void deleteAssignment(String complaintId) {
        assignmentRepository.deleteById(complaintId);
    }
}
