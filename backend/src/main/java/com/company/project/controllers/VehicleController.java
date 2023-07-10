//package com.company.project.controllers;
//import com.company.project.services.VehicleService;
//import com.fathzer.soft.javaluator.DoubleEvaluator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class VehicleController {
//
//    @Autowired
//    VehicleService service;
//
//  @CrossOrigin(origins = "http://localhost:3000")
//  @PostMapping
//
//
//  public String calculate(@RequestBody RequestBod requestbody) {
//        String expression = requestbody.getInput();
//        DoubleEvaluator eval = new DoubleEvaluator();
//
//        Double result = eval.evaluate(expression);
//        String output =result.toString();
//        return output;
//  }
//  public static class RequestBod{
//
//      private String input;
//
//      public String getInput() {
//        return input;
//        }
//
//      public void setInput(String input) {
//        this.input = input;
//      }
//    }
//}

