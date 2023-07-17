package com.company.project.controllers;

import com.company.project.entities.Model;
import com.company.project.services.ModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    ModelService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ArrayList<Model> getAllModels(){
        return service.getAllModels();
    }

    @PostMapping()
    public Model saveModel(@RequestBody Model model){
        return this.service.saveModel(model);
    }
}