package com.company.project.services;

import com.company.project.dto.ModelSaveDTO;
import com.company.project.entities.Make;
import com.company.project.entities.Model;
import com.company.project.entities.Type;
import com.company.project.repositories.MakeRepository;
import com.company.project.repositories.ModelRepository;
import com.company.project.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService{

    @Autowired
    ModelRepository ModelRepository;
    @Autowired
    MakeRepository MakeRepository;
    @Autowired
    TypeRepository TypeRepository;

    public ArrayList<Model> getAllModels(){
        return(ArrayList<Model>) ModelRepository.findAll();
    }

    public Model saveModel(ModelSaveDTO mockmodel){
        var model = new Model();
        var make = new Make();
        var type = new Type();
        model.setModel_name(mockmodel.getModel().getModel_name());
        model.setModel_slug(mockmodel.getModel().getModel_slug());
        model.setFk_model_make(MakeRepository.getMakeById(mockmodel.getMake_id()));
        model.setFk_model_type(TypeRepository.getTypeById(mockmodel.getType_id()));
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
                model.getFk_model_make(),
                model.getFk_model_type(),
                model.getModel_id()
        );
    }

}