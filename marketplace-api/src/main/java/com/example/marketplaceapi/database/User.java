package com.example.marketplaceapi.database;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
    private ObjectId user_id;



    public User(){

    }

    public User(ObjectId user_id) {
        this.user_id = user_id;
    }


}
