package com.company.project.controllers;

import com.company.project.entities.Type;
import com.company.project.services.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeService service;


    @GetMapping()
    public ArrayList<Type> getAllTypes(){
        return service.getAllTypes();
    }

    @PostMapping()
    public Type saveType(@RequestBody Type type){
        return this.service.saveType(type);
    }
}