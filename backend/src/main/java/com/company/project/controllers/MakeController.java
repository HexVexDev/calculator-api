package com.company.project.controllers;

import com.company.project.entities.Make;
import com.company.project.services.MakeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/makes")
public class MakeController {

    @Autowired
    MakeService service;


    @GetMapping()
    public ArrayList<Make> getAllMakes(){
        return service.getAllMakes();
    }

    @PostMapping()
    public void saveMake(@RequestBody Make make){
         this.service.saveMake(make);
    }
}
