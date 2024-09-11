package com.example.grievance.controller;

import com.example.grievance.model.Grievance;
import com.example.grievance.service.GrievanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private GrievanceService grievanceService;

    @GetMapping("/grievances")
    public List<Grievance> getAllGrievances() {
        return grievanceService.getAllGrievances();
    }

    @PostMapping("/grievances")
    public Grievance submitGrievance(@RequestBody Grievance grievance) {
        return grievanceService.saveGrievance(grievance);
    }
}

