package com.example.grievance.controller;

import com.example.grievance.model.Assignment;
import com.example.grievance.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignee")
public class AssigneeController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @PutMapping("/assignments")
    public Assignment updateAssignmentStatus(@RequestBody Assignment assignment) {
        return assignmentService.saveAssignment(assignment);
    }
}

