package com.example.grievance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "grievance")
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grievanceid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private role user;

    private String complaint;
    private String description;
    private LocalDateTime date = LocalDateTime.now();
    private String statusupdate;
}

