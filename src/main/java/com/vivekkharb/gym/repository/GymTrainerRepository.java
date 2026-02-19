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

    //get trainer by id
    @Query(value = "SELECT * FROM GYM_TRAINER WHERE ID = :id", nativeQuery = true)
    GymTrainer findTrainerById(@Param("id") int id);

    //get trainer by name , here assuming their can be more than 1 trainer by same name
    @Query(value = "SELECT * FROM GYM_TRAINER WHERE LOWER(NAME) = LOWER(:name)", nativeQuery = true)
    List<GymTrainer> findTrainersByName(@Param("name") String name);

    // get trainers in decreaing order of expericence
    @Query(value = "SELECT * FROM GYM_TRAINER ORDER BY EXPERIENCEYEARS DESC", nativeQuery = true)
    List<GymTrainer> findAllTrainersByExperienceDesc();

    // get most experienced trainer , use LIMIT 1 in above query ,

    // we can also make query such get most experience by gender or for each gender
    // or most experience for a particular specialisation
    // we will handle them later.
    // we will handle them later.





    // INSERT (Native)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO GYM_TRAINER (NAME, SPECIALTY, EXPERIENCEYEARS) " +
            "VALUES (:name, :specialty, :experienceYears)",
            nativeQuery = true)
    void insertTrainerNative(@Param("name") String name,
                             @Param("specialty") String specialty,
                             @Param("experienceYears") int experienceYears);



    @Modifying
    @Transactional
    @Query(value= "DELETE FROM GYM_TRAINER WHERE ID= :id",nativeQuery = true)
    void deleteSingleTrainerByID(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value= "DELETE FROM GYM_TRAINER WHERE ID IN (:ids)",nativeQuery = true)
    void deleteMultipleTrainersByIDs(@Param("ids") List<Integer> ids);



}
