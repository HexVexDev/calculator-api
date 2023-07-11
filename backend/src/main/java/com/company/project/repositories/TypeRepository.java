package com.company.project.repositories;

import com.company.project.entities.Model;
import com.company.project.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    @Query("SELECT t FROM Type t WHERE t.type_id = ?1 ")
    public Type getTypeById(Integer typeid);
}