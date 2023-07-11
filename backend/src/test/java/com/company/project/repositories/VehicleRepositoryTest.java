package com.company.project.repositories;


import com.company.project.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest

public class VehicleRepositoryTest {
    @Autowired
    private ModelRepository modrepo;
    @Autowired
    private MakeRepository makerepo;

    @Autowired VehicleRepository vecrepo;

    @Autowired TypeRepository typerepo;


    @Test
    public void VehicleRepository_getVehicleById_returnsObject() {
        //Arrange
        var Make = new Make();
        Make = makerepo.getMakeById(1);
        var Type = new Type();
        Type = typerepo.getTypeById(1);
        var Model = new Model();
        Model.setModel_name("Yaris");
        Model.setModel_makeid(Make);
        Model.setModel_typeid(Type);
        Model.setModel_slug("yaris");
        modrepo.saveAndFlush(Model);
        Model = modrepo.getModelById(1);
        //Act
        var Vehicle = new Vehicle();
        Vehicle.setVehicle_slug("sad");
        Vehicle.setVehicle_name("carrito");
        Vehicle.setVehicle_price(200);
        Vehicle.setVehicle_year(2000);
        Vehicle.setVehicle_vin("FXA34VS");
        Vehicle.setVehicle_modelid(Model);
        Vehicle.setVehicle_makeid(Make);
        vecrepo.saveAndFlush(Vehicle);
        Vehicle = vecrepo.getVehicleById(1);

        //Assert
        Assertions.assertNotNull(Vehicle);

    }

}