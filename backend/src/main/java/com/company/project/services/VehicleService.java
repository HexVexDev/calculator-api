package com.company.project.services;

import com.company.project.dto.VehicleSaveDTO;
import com.company.project.dto.VehicleUpdateDTO;
import com.company.project.entities.Vehicle;
import com.company.project.repositories.MakeRepository;
import com.company.project.repositories.ModelRepository;
import com.company.project.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService{

    @Autowired
    VehicleRepository VehicleRepository;
    @Autowired
    MakeRepository MakeRepository;
    @Autowired
    ModelRepository ModelRepository;

    public ArrayList<Vehicle> getAllVehicles(){
        return(ArrayList<Vehicle>) VehicleRepository.findAll();
    }

    public Vehicle saveVehicle(VehicleSaveDTO mockvehicle){
        var vehicle = new Vehicle();
        vehicle.setVehicle_name(mockvehicle.getVehicle().getVehicle_name());
        vehicle.setVehicle_vin(mockvehicle.getVehicle().getVehicle_vin());
        vehicle.setVehicle_year(mockvehicle.getVehicle().getVehicle_year());
        vehicle.setVehicle_price(mockvehicle.getVehicle().getVehicle_price());
        vehicle.setVehicle_slug(mockvehicle.getVehicle().getVehicle_slug());
        vehicle.setVehicle_makeid(MakeRepository.getMakeById(mockvehicle.getMake_id()));
        vehicle.setVehicle_modelid(ModelRepository.getModelById(mockvehicle.getModel_id()));
        return VehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Integer id){
        return VehicleRepository.getVehicleById(id);
    }
    @Transactional
    public void deleteVehiclebyId(Integer id){VehicleRepository.deleteVehicleById(id);
    }

    public void updateVehicleInfo(VehicleUpdateDTO mockvehicle){
        var vehicle = VehicleRepository.getVehicleById(mockvehicle.getVehicle().getId());
        vehicle.setVehicle_name(mockvehicle.getVehicle().getVehicle_name());
        vehicle.setVehicle_vin(mockvehicle.getVehicle().getVehicle_vin());
        vehicle.setVehicle_year(mockvehicle.getVehicle().getVehicle_year());
        vehicle.setVehicle_price(mockvehicle.getVehicle().getVehicle_price());
        vehicle.setVehicle_slug(mockvehicle.getVehicle().getVehicle_slug());
        vehicle.setVehicle_makeid(MakeRepository.getMakeById(mockvehicle.getMake_id()));
        vehicle.setVehicle_modelid(ModelRepository.getModelById(mockvehicle.getModel_id()));
        VehicleRepository.save(vehicle);
    }



}
