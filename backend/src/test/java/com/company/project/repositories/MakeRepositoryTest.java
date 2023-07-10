package com.company.project.repositories;

import com.company.project.entities.Make;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
@DataJpaTest

public class MakeRepositoryTest {
    @Autowired
    private MakeRepository makerepo;

    @Test
    public void MakeRepository_getMakeById_returnsObject(){

        //Arrange
        var make = new Make();

        //Act
        make = makerepo.getMakeById(1);

        //Assert
        Assertions.assertNotNull(make);

    }

}