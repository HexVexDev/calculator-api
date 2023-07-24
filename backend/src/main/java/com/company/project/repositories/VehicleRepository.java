package com.company.project.repositories;

import com.company.project.entities.Make;
import com.company.project.entities.Model;
import com.company.project.entities.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {


    @Query("SELECT v FROM Vehicle v WHERE v.vehicle_id =?1")
    Vehicle getVehicleById(Integer vehicleid);
    @Modifying
    @Query("DELETE FROM Vehicle v WHERE v.vehicle_id =?1")
    void deleteVehicleById(Integer vehicleid);





}
