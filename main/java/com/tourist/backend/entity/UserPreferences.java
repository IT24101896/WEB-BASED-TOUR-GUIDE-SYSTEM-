package com.tourist.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double beachScore = 0.0;
    private Double mountainScore = 0.0;
    private Double historyScore = 0.0;
    private Double natureScore = 0.0;
    private Double urbanScore = 0.0;
    private Double adventureScore = 0.0;
}
