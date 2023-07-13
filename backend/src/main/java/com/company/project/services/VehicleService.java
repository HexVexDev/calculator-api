package com.company.project.services;

import com.company.project.entities.Vehicle;
import com.company.project.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService{

    @Autowired
    VehicleRepository VehicleRepository;

    public ArrayList<Vehicle> getAllVehicles(){
        return(ArrayList<Vehicle>) VehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        return VehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Integer id){
        return VehicleRepository.getVehicleById(id);
    }

    public Vehicle deleteVehiclebyId(Integer id){
        return VehicleRepository.deleteVehicleById(id);
    }

    public void updateVehicleInfo(Vehicle vehicle){
         VehicleRepository.updateVehicleInfo(
                vehicle.getVehicle_name(),
                vehicle.getVehicle_price(),
                vehicle.getVehicle_vin(),
                vehicle.getVehicle_makeid(),
                vehicle.getVehicle_modelid(),
                vehicle.getId()
        );
    }

}
