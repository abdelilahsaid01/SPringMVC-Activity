package com.example.appjpa.repositories;

import com.example.appjpa.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNomContains(String name);

    List<Patient> findByMalade(boolean b);

    Page<Patient> findByMaladeAndScore(boolean isMalade, int score, Pageable pageable);

    Page<Patient> findByMaladeIsTrueAndScoreLessThan(int score, Pageable pageable);


    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
    List<Patient> checherPatient(@Param("x") Date d1, @Param("y") Date d2, @Param("z") String nom);
}