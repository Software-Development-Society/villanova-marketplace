package com.example.marketplaceapi.services;

import com.example.marketplaceapi.Utils.JsonUtils;
import com.example.marketplaceapi.Utils.ValidationUtils;
import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.exceptions.DatabaseException;
import com.example.marketplaceapi.exceptions.SvcException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

public class ActiveListingServices {
    private final static JSONParser parser = new JSONParser();

    public static ResponseEntity<String> createActiveListing(final String pPayload) {
        JSONObject ActiveListingJSON;
        try {
            ActiveListingJSON = (JSONObject) parser.parse(pPayload);
        }
        catch (ParseException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        ActiveListing activeListingToBeSaved;
        try{
            activeListingToBeSaved = JsonUtils.createActiveListingFromJSON(ActiveListingJSON);
            ValidationUtils.validateCreateActiveListing(activeListingToBeSaved);
        }
        catch (SvcException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        try{
            DatabaseServices.saveActiveListing(activeListingToBeSaved);
        }
        catch (DatabaseException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User created successfully");
    }

}
