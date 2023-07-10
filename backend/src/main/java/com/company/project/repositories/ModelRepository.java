package com.company.project.repositories;

import com.company.project.entities.Make;
import com.company.project.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT '*' FROM Model WHERE model_id = ?1 ")
    public Model getModelById(Integer modelid);
}