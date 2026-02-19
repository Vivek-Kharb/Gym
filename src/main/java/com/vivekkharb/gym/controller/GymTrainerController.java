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

    @GetMapping("/get-trainer-detail/{id}")
    public GymTrainer getTrainerById( @PathVariable int id) {
        return service.getTrainerById(id);
    }

    @GetMapping("/get-trainers-by-name/{name}")
    public List<GymTrainer> getTrainersByName(@PathVariable String name) {
        return service.getTrainersByName(name);
    }

    @GetMapping("/experience-desc")
    public List<GymTrainer> getTrainersByExperienceDesc() {
        return service.getTrainersByExperienceDesc();
    }


    // POST → http://localhost:8080/trainers
    @PostMapping("/addSingleTrainer")
    public String addTrainer(@RequestBody GymTrainer trainer) {
        service.addTrainer(trainer);
        return "Trainer added successfully!";
    }

    @PostMapping("/addMultipleTrainers")
    public String addMultipleTrainers(@RequestBody List<GymTrainer> trainers) {
        service.addMultipleTrainers(trainers);
        return "All trainers added successfully!";
    }

    @DeleteMapping("/delete-Single-Trainer-By-Id/{id}")
    public String deleteSingleTrainerbyID(@PathVariable int id) {
        service.deleteSingleTrainerByID(id);
        return "Trainer deleted successfully!";
    }


    @DeleteMapping("/deleteMultipleTrainersByIDs")
    public String deleteMultipleTrainersByIDs( @RequestBody List<Integer> ids) {
        service.deleteMultipleTrainersByIDs(ids);
        return "Multiple Trainers deleted successfully!";
    }

}
