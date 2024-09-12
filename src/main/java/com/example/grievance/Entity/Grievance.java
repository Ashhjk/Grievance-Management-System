package com.example.grievance.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "grievance")
public class Grievance {

    @Id
    @Column(name = "complaint_id")
    private String complaint_id; // Alphanumeric and auto-generated

    @Column(name = "consumer_id")
    private int consumer_id; // Should start with 100

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "status")
    private String status; // Default: 'submitted'

    // Constructor
    public Grievance() {
        this.status = "submitted"; // Sets the default status as 'submitted'
    }

    // Method to generate alphanumeric complaint_id
    @PrePersist
    private void prePersist() {
        if (this.complaint_id == null) {
            this.complaint_id = generateAlphanumericId(); // Generates a random alphanumeric complaint_id
        }
    }

    private String generateAlphanumericId() {
        return "CMP" + UUID.randomUUID().toString().replace("-", "").substring(0, 8); // Generates a random alphanumeric complaint_id
    }

    // Getters and Setters
    public int getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(int consumer_id) {
        this.consumer_id = consumer_id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(String complaint_id) {
        this.complaint_id = complaint_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
