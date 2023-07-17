package com.company.project.controllers;

import com.company.project.entities.Make;
import com.company.project.services.MakeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/makes")
public class MakeController {

    @Autowired
    MakeService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ArrayList<Make> getAllMakes(){
        return service.getAllMakes();
    }

    @PostMapping()
    public Make saveMake(@RequestBody Make make){
        return this.service.saveMake(make);
    }
}
