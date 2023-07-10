package com.company.project.repositories;

import com.company.project.entities.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {

    @Query("SELECT '*' FROM Make WHERE make_id = ?1 ")
    public Make getMakeById(Integer makeid);
}