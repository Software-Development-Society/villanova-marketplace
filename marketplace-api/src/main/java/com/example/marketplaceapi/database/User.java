package com.example.marketplaceapi.database;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "users")
public class User {
    @Id
    private ObjectId user_id;

    @Field
    private String firstName;

    @Field
    private String lastName;

    @Field
    private String email;

    @Field
    private int classYear;

    @Field
    private String major;

    @Field
    private ArrayList<ObjectId> wishList;

    @Field
    private boolean registrationComplete;






    public User(){

    }

    public User(ObjectId user_id, String firstName, String lastName, String email, int classYear, String major, ArrayList<ObjectId> wishList, boolean registrationComplete) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.classYear = classYear;
        this.major = major;
        this.wishList = wishList;
        this.registrationComplete = registrationComplete;
    }


    public User(String firstName, String lastName, String email, int classYear, String major, ArrayList<ObjectId> wishList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.classYear = classYear;
        this.major = major;
        this.wishList = wishList;
    }

    public User(ObjectId user_id, String firstName, String lastName, String email, int classYear, String major, ArrayList<ObjectId> wishList) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.classYear = classYear;
        this.major = major;
        this.wishList = wishList;
    }

    public ObjectId getUser_id(){
        return this.user_id;
    }




}
