package com.example.marketplaceapi.services;


import org.bson.types.Binary;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JsonUtilTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void parseActiveListingJson() {
        JSONObject json = new JSONObject();
        json.put("listing_id", "0");
        json.put("productName_", "Chair");
        json.put("description", "red");
        json.put("price", 0);
        json.put("pictures", new ArrayList<Binary>());
        json.put("sellerName","Elias");
        json.put("seller_id","epauli01");
        json.put("tags","tagger");
        json.put("views","view");
        json.put("condition","good");
        json.put("dateAdded","1/1/23");
    }
}

