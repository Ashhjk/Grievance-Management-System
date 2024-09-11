package com.example.grievance.controller;

import com.example.grievance.model.Assignment;
import com.example.grievance.model.Grievance;
import com.example.grievance.service.AssignmentService;
import com.example.grievance.service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController {
    @Autowired
    private GrievanceService grievanceService;

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/grievances")
    public List<Grievance> getAllGrievances() {
        return grievanceService.getAllGrievances();
    }

    @PostMapping("/assign")
    public Assignment assignGrievance(@RequestBody Assignment assignment) {
        return assignmentService.saveAssignment(assignment);
    }
}

