package com.company.project.repositories;

import com.company.project.entities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest

public class TypeRepositoryTest {
    @Autowired
    private TypeRepository typerepo;

    @Test
    public void TypeRepository_getTypeById_returnsObject(){
       //Arrange
        var Type = new Type();
        //Act
        Type = typerepo.getTypeById(1);
        //Assert
        Assertions.assertNotNull(Type);

    }

}