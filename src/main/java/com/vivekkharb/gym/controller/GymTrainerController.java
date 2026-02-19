package com.vivekkharb.gym.controller;

import com.vivekkharb.gym.entity.GymTrainer;
import com.vivekkharb.gym.service.GymTrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class GymTrainerController {

    private final GymTrainerService service;

    public GymTrainerController(GymTrainerService service) {
        this.service = service;
    }

    // GET → http://localhost:8080/trainers
    @GetMapping
    public List<GymTrainer> getAllTrainers() {
        return service.getAllTrainers();
    }

    // POST → http://localhost:8080/trainers
    @PostMapping
    public String addTrainer(@RequestBody GymTrainer trainer) {
        service.addTrainer(trainer);
        return "Trainer added successfully!";
    }
}
