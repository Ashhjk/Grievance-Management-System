package com.example.grievance.model;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "role")
public class role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private String name;
    private String username;
    private String password;
    private String role;
}
