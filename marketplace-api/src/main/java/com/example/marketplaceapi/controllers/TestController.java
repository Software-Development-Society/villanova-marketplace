package com.example.marketplaceapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/init-test")
    public String initTest(){
        System.out.println("Everything looks good!");
        return "Looks good!";

    }
}
