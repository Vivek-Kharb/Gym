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

    //used only GymTrainer as return type because expecting only one row
    //there can be error/exception if no row is present
    //that handling needs to be practiced

    public GymTrainer getTrainerById(int id) {
        return repository.findTrainerById(id);
    }

    public List<GymTrainer> getTrainersByName(String name) {
        return repository.findTrainersByName(name);
    }

    public List<GymTrainer> getTrainersByExperienceDesc(){
        return repository.findAllTrainersByExperienceDesc();
    }

    public void addTrainer(GymTrainer trainer) {
        repository.insertTrainerNative(
                trainer.getName(),
                trainer.getSpecialty(),
                trainer.getExperienceYears()
        );
    }

    //here I can use @Transctional annotation for all or nothing means if
    //there is some mistake in input data for rows creation then complete transtion
    //will abort, but I'm not using that as of now
    public void addMultipleTrainers(List<GymTrainer> trainers) {
        for(GymTrainer trainer : trainers){
            repository.insertTrainerNative( // means we are using same method n number of times
                    trainer.getName(),
                    trainer.getSpecialty(),
                    trainer.getExperienceYears()
            );
        }

    }

    public void deleteSingleTrainerByID(int id){
        repository.deleteSingleTrainerByID(id);
    }

    public void deleteMultipleTrainersByIDs(List<Integer> ids){
            repository.deleteMultipleTrainersByIDs(ids);
    }
}
