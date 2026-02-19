package com.vivekkharb.gym.repository;

import com.vivekkharb.gym.entity.Client;
import com.vivekkharb.gym.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Fetch all clients
    @Query(value = "SELECT * FROM CLIENT", nativeQuery = true)
    List<Client> findAllClientsNative();

    // Insert a single client (native query)
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CLIENT(name, date_of_birth, gender, course_type) " +
            "VALUES (:name, :dob, :gender, :courseType)", nativeQuery = true)
    void insertClientNative(@Param("name") String name,
                            @Param("dob") String dateOfBirth,
                            @Param("gender") String gender,
                            @Param("courseType") String courseType);
}
