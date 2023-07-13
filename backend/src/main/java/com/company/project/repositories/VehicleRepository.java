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


    @Query("SELECT v FROM Vehicle v WHERE v.id =?1")
    Vehicle getVehicleById(Integer vehicleid);
    @Modifying
    @Query("DELETE FROM Vehicle v WHERE v.id =?1")
    Vehicle deleteVehicleById(Integer vehicleid);

    @Modifying
    @Query("UPDATE Vehicle v SET v.vehicle_name =?1, v.vehicle_price=?2, v.vehicle_vin=?3,v.vehicle_year=?4,v.fk_vehicle_make=?5,v.fk_vehicle_model=?6 WHERE v.id=?7")
    void updateVehicleInfo(
            @Param("vehicle_name") String vehicle_name,
            @Param("vehicle_price") Integer vehicle_price,
            @Param("vehicle_vin") String vehicle_vin,
            @Param("fk_vehicle_make") Make fk_vehicle_make,
            @Param("fk_vehicle_model") Model fk_vehicle_model,
            @Param("id")Integer id);





}
