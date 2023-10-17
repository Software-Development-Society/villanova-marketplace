package com.example.marketplaceapi.services;


import com.example.marketplaceapi.database.ActiveListing;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void parseActiveListingJson() {
        ObjectId fakeObjectId = new ObjectId();
        JSONObject json = new JSONObject();
        json.put("productName", "chair");
        json.put("description", "red");
        json.put("price", 0);
        json.put("pictures", new ArrayList<Binary>());
        json.put("sellerName","Elias");
        json.put("seller_id", fakeObjectId);
        json.put("tags",new ArrayList<String>());
        json.put("views", 0);
        json.put("condition","good");
        json.put("date", new Date("1/1/2023"));

        ActiveListing expectedValue = new ActiveListing("chair","red",0, new ArrayList<Binary>(), "Elias", fakeObjectId, new ArrayList<String>(), 0, "good", new Date("1/1/2023"));
        assertEquals(JsonUtil.getActiveListingFromJson(json), expectedValue);
    }





}

