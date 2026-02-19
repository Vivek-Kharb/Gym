package com.vivekkharb.gym.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GYM_TRAINER")
public class GymTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SPECIALTY")
    private String specialty;

    @Column(name = "EXPERIENCEYEARS")
    private int experienceYears;

    public GymTrainer() {}

    public GymTrainer(String name, String specialty, int experienceYears) {
        this.name = name;
        this.specialty = specialty;
        this.experienceYears = experienceYears;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
}
