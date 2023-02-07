package com.example.marketplaceapi.controllers;

import groovy.json.JsonSlurper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final JsonSlurper slurper =  new JsonSlurper();

    @GetMapping("/init-test")
    public String initTest(){
        System.out.println("Everything looks good!");
        return "Looks good!";

    }
}
