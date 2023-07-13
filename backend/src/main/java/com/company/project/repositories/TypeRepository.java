package com.company.project.repositories;

import com.company.project.entities.Model;
import com.company.project.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    @Query("SELECT t FROM Type t WHERE t.type_id = ?1 ")
    public Type getTypeById(Integer typeid);

    @Modifying
    @Query("DELETE FROM Type t WHERE t.type_id =?1")
    void deleteTypeById(Integer type_id);

    @Modifying
    @Query("UPDATE Type t SET t.type_name =?1 WHERE t.type_id=?2")
    void updateType(
            @Param("type_name") String type_name,
            @Param("type_id") Integer type_id);


}