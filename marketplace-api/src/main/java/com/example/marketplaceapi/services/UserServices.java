package com.example.marketplaceapi.services;

import com.example.marketplaceapi.Utils.JsonUtils;
import com.example.marketplaceapi.Utils.ValidationUtils;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.DatabaseException;
import com.example.marketplaceapi.exceptions.SvcException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

public class UserServices {
    static JSONParser parser = new JSONParser();

    public static ResponseEntity<String> createUser(final String pPayload) {
        JSONObject UserJSON;
        try {
            UserJSON = (JSONObject) parser.parse(pPayload);
        }
        catch (ParseException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid JSON");
        }

        User userToBeSaved;
        try{
            userToBeSaved = JsonUtils.createUserFromJSON(UserJSON);
            ValidationUtils.validateCreateUser(userToBeSaved);
        }
        catch (SvcException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        try{
            DatabaseServices.saveUser(userToBeSaved);
        }
        catch (DatabaseException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User created successfully");
    }
}
