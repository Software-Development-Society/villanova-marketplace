package com.example.marketplaceapi.database;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "activelistings")
public class ActiveListing {
    @Id
    private ObjectId listing_id;

    @Field
    private String productName;

    @Field
    private String description;

    @Field
    private int price;

    @Field
    private ArrayList<Binary> pictures;

    @Field
    private String sellerName;

    @Field
    private ObjectId seller_id;

    @Field
    private ArrayList<String> tags;

    @Field
    private int views;

    @Field
    private String condition;

    @Field
    private Date dateAdded;






    public ActiveListing() {
    }

    public ActiveListing(ObjectId listing_id, String productName, String description, int price, ArrayList<Binary> pictures, String sellerName, ObjectId seller_id, ArrayList<String> tags, int views, String condition, Date dateAdded) {
        this.listing_id = listing_id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.pictures = pictures;
        this.sellerName = sellerName;
        this.seller_id = seller_id;
        this.tags = tags;
        this.views = views;
        this.condition = condition;
        this.dateAdded = dateAdded;
    }

    public ActiveListing(String productName, String description, int price, ArrayList<Binary> pictures, String sellerName, ObjectId seller_id, ArrayList<String> tags, int views, String condition, Date dateAdded) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.pictures = pictures;
        this.sellerName = sellerName;
        this.seller_id = seller_id;
        this.tags = tags;
        this.views = views;
        this.condition = condition;
        this.dateAdded = dateAdded;
    }

    // example get method

    public ObjectId getListing_id() {
        return listing_id;
    }

    // add other get methods here



    // example set method

    public void setListing_id(ObjectId listing_id) {
        this.listing_id = listing_id;
    }
    // add other set methods here
}
