package com.company.project.dto;


import com.company.project.entities.Vehicle;

import java.util.Objects;

public class VehicleUpdateDTO {
    private Vehicle vehicle;
    private Integer make_id;
    private Integer model_id;

    // No-arguments constructor
    public VehicleUpdateDTO() {
    }

    // Constructor with Model parameter
    public VehicleUpdateDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Getter for 'model' field
    public Vehicle getVehicle() {
        return vehicle;
    }

    public Integer getMake_id() {
        return make_id;
    }

    public Integer getModel_id() {
        return model_id;
    }

    // Setter for 'model' field
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setMake_id(Integer make_id) {
        this.make_id = make_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    // toString() method

}