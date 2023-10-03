package com.example.marketplaceapi.services;

import com.example.marketplaceapi.database.ActiveListing;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class JsonUtil {
    public static ActiveListing getActiveListingFromJson(JSONObject Json) {
        ActiveListing activeListing = new ActiveListing();

        try {
            activeListing.setListing_id((ObjectId) Json.get("listing_id"));
            activeListing.setProductName((String) Json.get("productName"));
            activeListing.setDescription((String) Json.get("description"));
            activeListing.setPrice((int) Json.get("price"));
            activeListing.setPictures((ArrayList<Binary>) Json.get("pictures"));
            activeListing.setSellerName((String) Json.get("sellerName"));
            activeListing.setSeller_id((ObjectId) Json.get("seller_id"));
            activeListing.setTags((ArrayList<String>) Json.get("tags"));
            activeListing.setViews((int) Json.get("views"));
            activeListing.setCondition((String) Json.get("condition"));
            activeListing.setDateAdded((Date) Json.get("date"));
        }
        catch(Exception e) {
            // throw new ActiveListing();
        }

        return activeListing;

    }
}
