package com.example.marketplaceapi.controllers;

import org.bson.json.JsonObject;
import org.bson.types.ObjectId;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.HashMap;

@RestController
public class TestController {



    // EXAMPLE API ENDPOINT - GET METHOD
    @GetMapping("/get-test") // GetMapping states the type of request, here it is a get request and the "/...." is the url endpoint
    public String initTest() {
        System.out.println("Everything looks good!");
        // logic done here
        return "Looks good!";

    }

    // EXAMPLE API ENDPOINT - POST METHOD
    @PostMapping("/post-test") // PostMapping states the type of the method
    public String test(@RequestBody String input) throws ParseException {
        // takes a JSON string as an input parses the string and gets the necessary elements
        Object obj = new JSONParser().parse(input);
        JSONObject jo = (JSONObject) obj;
        return (String) jo.get("user_id");
    }
}
