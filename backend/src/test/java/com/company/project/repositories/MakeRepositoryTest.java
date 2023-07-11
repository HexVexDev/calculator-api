package com.company.project.repositories;

import com.company.project.entities.Make;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest

public class MakeRepositoryTest {
    @Autowired
    private MakeRepository makerepo;

    @Test
    public void MakeRepository_getMakeById_returnsObject(){

        //Arrange
        var make = new Make();
        make.setMake_name("Toyota");
        make.setMake_slug("toyota");

        //Act
        makerepo.save(make);
        make = makerepo.getMakeById(1);
        //Assert
        Assertions.assertNotNull(make);

    }

    @Test
    public void MakeRepository_getMakeByName_returnsObject(){
        var makeresults = new Make();
        makeresults = makerepo.getMakeByName("Toyota");


        Assertions.assertNotNull(makeresults);

    }

}