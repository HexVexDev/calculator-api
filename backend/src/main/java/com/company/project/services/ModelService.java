package com.company.project.services;

import com.company.project.entities.Model;
import com.company.project.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService{

    @Autowired
    ModelRepository ModelRepository;

    public ArrayList<Model> getAllModels(){
        return(ArrayList<Model>) ModelRepository.findAll();
    }

    public Model saveModel(Model model){
        return ModelRepository.save(model);
    }

    public Model getModelById(Integer id){
        return ModelRepository.getModelById(id);
    }

    public void deleteModelbyId(Integer id){
        ModelRepository.deleteModelById(id);
    }

    public void updateModel(Model model){
        ModelRepository.updateModel(
               model.getModel_name(),
                model.getModel_slug(),
                model.getModel_makeid(),
                model.getModel_typeid(),
                model.getId()
        );
    }

}