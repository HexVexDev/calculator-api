package com.company.project.repositories;

import com.company.project.entities.Make;
import com.company.project.entities.Model;
import com.company.project.entities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest

public class ModelRepositoryTest {
    @Autowired
    private ModelRepository modrepo;
    @Autowired
    private MakeRepository makerepo;
    @Autowired
    private TypeRepository typerepo;

    @Test
    public void ModelRepository_getModelById_returnsObject() {
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

        //Act
        modrepo.save(Model);
        Model = modrepo.getModelById(1);
        //Assert
        Assertions.assertNotNull(Model);

    }

}