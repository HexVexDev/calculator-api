package com.company.project.services;

import com.company.project.entities.Type;
import com.company.project.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService{

    @Autowired
    TypeRepository TypeRepository;

    public ArrayList<Type> getAllTypes(){
        return(ArrayList<Type>) TypeRepository.findAll();
    }

    public Type saveType(Type type){
        return TypeRepository.save(type);
    }

    public Type getTypeById(Integer id){
        return TypeRepository.getTypeById(id);
    }

    public void deleteTypebyId(Integer id){
        TypeRepository.deleteTypeById(id);
    }

    public void updateType(Type type){
        TypeRepository.updateType(
                type.getType_name(),
                type.getId()
        );
    }

}