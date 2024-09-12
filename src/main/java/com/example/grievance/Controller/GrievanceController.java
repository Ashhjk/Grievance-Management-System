package com.example.grievance.Controller;

import com.example.grievance.Entity.Grievance;
import com.example.grievance.Service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceService grievanceService;

    @PostMapping
    public Grievance createGrievance(@RequestBody Grievance grievance) {
        return grievanceService.saveGrievance(grievance);
    }

    @GetMapping
    public List<Grievance> getAllGrievances() {
        return grievanceService.getAllGrievances();
    }
    @PutMapping("/{complaint_id}")
    public Grievance updateGrievance(
            @PathVariable String complaint_id,
            @RequestBody Grievance updatedGrievance) {
        return grievanceService.updateGrievance(complaint_id, updatedGrievance);
    }

    @GetMapping("/{complaintId}")
    public Optional<Grievance> getGrievanceById(@PathVariable String complaintId) {
        return grievanceService.getGrievanceById(complaintId);
    }

    @DeleteMapping("/{complaintId}")
    public void deleteGrievance(@PathVariable String complaintId) {
        grievanceService.deleteGrievance(complaintId);
    }
}
