package com.company.project.controllers;

import com.company.project.dto.ModelSaveDTO;
import com.company.project.entities.Model;
import com.company.project.services.MakeService;
import com.company.project.services.ModelService;

import com.company.project.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/models")
public class ModelController {

    @Autowired
    ModelService service;
    @Autowired
    MakeService makeService;
    @Autowired
    TypeService typeService;


    @GetMapping()
    public ArrayList<Model> getAllModels(){
        return service.getAllModels();
    }

    @PostMapping()
    public Model saveModel(@RequestBody ModelSaveDTO mockmodel){

       return service.saveModel(mockmodel);

    }


}