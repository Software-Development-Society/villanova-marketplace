package com.example.marketplaceapi.controllers;


import com.example.marketplaceapi.services.UserServices;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    static JSONParser parser = new JSONParser();

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody final String pPayload) {

        return UserServices.createUser(pPayload);
    }




}
