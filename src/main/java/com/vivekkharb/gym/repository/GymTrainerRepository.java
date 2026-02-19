package com.vivekkharb.gym.repository;

import com.vivekkharb.gym.entity.GymTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public interface GymTrainerRepository extends JpaRepository<GymTrainer, Long> {

    // GET ALL (Native)
    @Query(value = "SELECT * FROM GYM_TRAINER", nativeQuery = true)
    List<GymTrainer> findAllTrainersNative();

    // INSERT (Native)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO GYM_TRAINER (NAME, SPECIALTY, EXPERIENCEYEARS) " +
            "VALUES (:name, :specialty, :experienceYears)",
            nativeQuery = true)
    void insertTrainerNative(@Param("name") String name,
                             @Param("specialty") String specialty,
                             @Param("experienceYears") int experienceYears);
}
