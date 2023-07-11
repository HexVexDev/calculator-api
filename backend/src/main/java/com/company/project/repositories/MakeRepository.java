package com.company.project.repositories;

import com.company.project.entities.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {
    //Retrieve Make by Id(All data)
    @Query("SELECT m FROM Make m WHERE m.make_id = ?1 ")
    public Make getMakeById(Integer makeid);

    //Retrieve Make by Name
    @Query("SELECT m FROM Make m WHERE m.make_name = ?1 ")
    public Make getMakeByName(String makename);
}