package com.example.grievance.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentid;

    @ManyToOne
    @JoinColumn(name = "complaintid")
    private Grievance complaint;

    @ManyToOne
    @JoinColumn(name = "assigneeid")
    private role assignee;

    @ManyToOne
    @JoinColumn(name = "userid")
    private role user;

    private String statusupdate;
}
