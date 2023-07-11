package com.company.project.repositories;

import com.company.project.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT m FROM Model m WHERE m.model_id = ?1 ")
    Model getModelById(Integer modelid);
}