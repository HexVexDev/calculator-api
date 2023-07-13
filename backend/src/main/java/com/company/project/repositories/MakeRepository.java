package com.company.project.repositories;

import com.company.project.entities.Make;
import com.company.project.entities.Model;
import com.company.project.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Modifying
    @Query("DELETE FROM Make m WHERE m.make_id =?1")
    void deleteMakeById(Integer makeid);

    @Modifying
    @Query("UPDATE Make m SET m.make_name =?1, m.make_slug=?2 WHERE m.make_id=?3")
    void updateMake(
            @Param("make_name") String make_name,
            @Param("make_slug") String make_slug,
            @Param("make_id")Integer make_id);

}