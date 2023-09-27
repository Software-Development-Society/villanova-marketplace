package com.example.marketplaceapi.Utils;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.SvcException;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static User createUserFromJSON(final JSONObject pJSONObject) throws SvcException{
        final User user = new User();
        try{
            user.setUser_id(new ObjectId((String) pJSONObject.get("user_id")));
            user.setFirstName((String) pJSONObject.get("firstName"));
            user.setLastName((String) pJSONObject.get("lastName"));
            user.setEmail((String) pJSONObject.get("email"));
            user.setClassYear((int) pJSONObject.get("classYear"));
            user.setMajor((String) pJSONObject.get("major"));
            ArrayList<ObjectId> wishList = new ArrayList<>((ArrayList<ObjectId>) pJSONObject.get("wishList"));
            user.setWishList(wishList);
            user.setRegistrationComplete((boolean) pJSONObject.get("registrationComplete"));
        }
        catch (Exception e){
            e.printStackTrace();
            throw new SvcException("Error creating user from JSON");
        }
        return user;
    }
}
