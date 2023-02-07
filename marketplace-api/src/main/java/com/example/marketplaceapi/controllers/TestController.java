package com.example.marketplaceapi.controllers;

import groovy.json.JsonSlurper;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.HashMap;

@RestController
public class TestController {
    private static final JsonSlurper slurper =  new JsonSlurper();


    // EXAMPLE API ENDPOINT - GET METHOD
    @GetMapping("/init-test") // GetMapping states the type of method and the "/...." is the url endpoint
    public String initTest() {
        System.out.println("Everything looks good!");
        // logic done here
        return "Looks good!";

    }
}
