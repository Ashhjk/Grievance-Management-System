package com.example.grievance.Controller;

import com.example.grievance.Entity.Assignment;
import com.example.grievance.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;
    @PutMapping("/{complaint_id}")
    public Assignment updateAssignment(@PathVariable String complaint_id, @RequestBody Assignment updatedAssignment) {
        return assignmentService.updateAssignment(complaint_id, updatedAssignment);
    }
    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.saveAssignment(assignment);
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{complaint_id}")
    public Optional<Assignment> getAssignmentById(@PathVariable String complaint_id) {
        return assignmentService.getAssignmentById(complaint_id);
    }

    @DeleteMapping("/{complaint_id}")
    public void deleteAssignment(@PathVariable String complaint_id) {
        assignmentService.deleteAssignment(complaint_id);
    }
}
