package com.company.project.entities;

import jakarta.persistence.*;


@Entity
public class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //All field declaration for ORM
    @Id
    @Column(name = "vehicle_id")
    private int id;

    @Basic
    @Column(name = "slug")
    private String vehicle_slug;

    @Basic
    @Column(name = "vehicle_name")
    private String vehicle_name;

    @Basic
    @Column(name="vehicle_year")
    private Integer vehicle_year;

    @Basic
    @Column(name = "vehicle_price")
    private Integer vehicle_price;

    @Basic
    @Column(name="vehicle_vin")
    private String vehicle_vin;
    //Foreign Key relationship declaration
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="make_id")
    private Make fk_vehicle_make;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="model")
    private Model fk_vehicle_model;
    //Setters and getters
    public int getId(){ return id;}

    public void setId(int id){this.id = id;}

    public String getVehicle_slug(){return vehicle_slug;}
    public void setVehicle_slug (String vehicle_slug){this.vehicle_slug = vehicle_slug;}

    public String getVehicle_name(){return vehicle_name;}

    public void setVehicle_name (String vehicle_name){this.vehicle_name = vehicle_name;}

    public Integer getVehicle_year(){return vehicle_year;}

    public void setVehicle_year (Integer vehicle_year){this.vehicle_year = vehicle_year;}

    public Integer getVehicle_price(){return vehicle_price;}

    public void setVehicle_price(Integer vehicle_price){this.vehicle_price = vehicle_price;}

    public String getVehicle_vin(){return vehicle_vin;}

    public void setVehicle_vin (String vehicle_vin){this.vehicle_vin = vehicle_vin;}

    public Make getVehicle_makeid(){return fk_vehicle_make;}

    public void setVehicle_makeid(Make fk_vehicle_make){this.fk_vehicle_make = fk_vehicle_make;}

    public Model getVehicle_modelid(){return fk_vehicle_model;}

    public void setVehicle_modelid(Model fk_vehicle_model){this.fk_vehicle_model = fk_vehicle_model;}
}
