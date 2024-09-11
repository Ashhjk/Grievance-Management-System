package com.example.grievance.service;

import com.example.grievance.model.role;
import com.example.grievance.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<role> getAllRoles() {
        return roleRepository.findAll();
    }

    public role saveRole(role role) {
        return roleRepository.save(role);
    }
}

