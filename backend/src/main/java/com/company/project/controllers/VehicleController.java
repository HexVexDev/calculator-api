package com.company.project.controllers;

import com.company.project.entities.Vehicle;
import com.company.project.services.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ArrayList<Vehicle> getAllVehicles(){
        return service.getAllVehicles();
    }

    @PostMapping()
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return this.service.saveVehicle(vehicle);
    }
}


