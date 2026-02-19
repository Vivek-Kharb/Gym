package com.vivekkharb.gym.service;

import com.vivekkharb.gym.entity.GymTrainer;
import com.vivekkharb.gym.repository.GymTrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymTrainerService {

    private final GymTrainerRepository repository;

    public GymTrainerService(GymTrainerRepository repository) {
        this.repository = repository;
    }

    public List<GymTrainer> getAllTrainers() {
        return repository.findAllTrainersNative();
    }

    public void addTrainer(GymTrainer trainer) {
        repository.insertTrainerNative(
                trainer.getName(),
                trainer.getSpecialty(),
                trainer.getExperienceYears()
        );
    }
}
