package com.company.project.repositories;

import com.company.project.entities.Make;
import com.company.project.entities.Model;
import com.company.project.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT m FROM Model m WHERE m.model_id = ?1 ")
    Model getModelById(Integer modelid);

    @Modifying
    @Query("DELETE FROM Model m WHERE m.model_id =?1")
    void deleteModelById(Integer modelid);

    @Modifying
    @Query("UPDATE Model e SET e.model_name =?1, e.model_slug=?2, e.fk_model_make=?3,e.fk_model_type=?4 WHERE e.model_id=?5")
    void updateModel(
            @Param("model_name") String model_name,
            @Param("model_slug") String model_slug,
            @Param("fk_model_make") Make fk_model_make,
            @Param("fk_model_type") Type fk_model_type,
            @Param("model_id") Integer model_id);


}