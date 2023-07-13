package com.company.project.services;

import com.company.project.entities.Make;
import com.company.project.repositories.MakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MakeService{

    @Autowired
    MakeRepository MakeRepository;

    public ArrayList<Make> getAllMakes(){
        return(ArrayList<Make>) MakeRepository.findAll();
    }

    public Make saveMake(Make make){
        return MakeRepository.save(make);
    }

    public Make getMakeById(Integer id){
        return MakeRepository.getMakeById(id);
    }

    public void deleteMakebyId(Integer id){
         MakeRepository.deleteMakeById(id);
    }

    public void updateMake(Make make){
        MakeRepository.updateMake(
                make.getMake_name(),
                make.getMake_slug(),
                make.getId()
        );
    }

}