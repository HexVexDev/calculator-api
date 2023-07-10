package com.company.project.repositories;

import com.company.project.entities.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {


    @Query("select '*' FROM Vehicle")
    public Vehicle getAllVehicles();








}
