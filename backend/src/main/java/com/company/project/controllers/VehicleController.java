package com.company.project.controllers;

import com.company.project.dto.VehicleSaveDTO;
import com.company.project.entities.Vehicle;
import com.company.project.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;


    @GetMapping()
    public ArrayList<Vehicle> getAllVehicles(){
        return service.getAllVehicles();
    }

    @PostMapping()
    public Vehicle saveVehicle(@RequestBody VehicleSaveDTO vehicle){
        return this.service.saveVehicle(vehicle);
    }

    @PutMapping()
    public void updateVehicle(@RequestBody Vehicle vehicle){ this.service.updateVehicleInfo(vehicle);}

    @DeleteMapping()
    public void deleteVehicle(@RequestBody Integer vehicle_id) {service.deleteVehiclebyId(vehicle_id);}
}


