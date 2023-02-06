package com.example.marketplaceapi.database;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "completedlistings")
public class CompletedListing {
    @Id
    private ObjectId listing_id;


    public CompletedListing() {
    }
}
