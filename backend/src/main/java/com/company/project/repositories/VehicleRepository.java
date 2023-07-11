package com.company.project.repositories;

import com.company.project.entities.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {


    @Query("SELECT v FROM Vehicle v WHERE v.id =?1")
    Vehicle getVehicleById(Integer vehicleid);








}
