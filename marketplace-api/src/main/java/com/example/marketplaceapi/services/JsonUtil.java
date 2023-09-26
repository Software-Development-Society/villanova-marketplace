package com.example.marketplaceapi.services;

import com.example.marketplaceapi.database.ActiveListing;
import org.bson.json.JsonObject;

public class JsonUtil {
    public static ActiveListing getActiveListingFromJson(JsonObject Json) {
        String[] variables = {"listing_id", "productName", "description", "price", "pictures", "sellerName", "seller_id", "tags", "views", "condition", "dateAdded"};

        for (int i = 0; i < variables.length; i++) {
            
        }
        if (Json.get("listing_id") != null)    {

        }
        else {

        }


    }
}
