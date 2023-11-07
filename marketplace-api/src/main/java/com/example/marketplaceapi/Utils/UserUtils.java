package com.example.marketplaceapi.Utils;

import com.example.marketplaceapi.database.User;
import org.bson.types.ObjectId;

import java.util.HashMap;

public class UserUtils {

    public static User updateUser(HashMap<String, String> check, User previousUser) {
        User userChanging = previousUser;
        if (check.containsKey("user_id")) {
            userChanging.setUser_id(new ObjectId(check.get("user_id")));
        }

        if (check.containsKey("firstName")) {
            userChanging.setUser_id(new ObjectId(check.get("firstName")));
        }

        if (check.containsKey("lastName")) {
            userChanging.setUser_id(new ObjectId(check.get("lastName")));
        }

        if (check.containsKey("email")) {
            userChanging.setUser_id(new ObjectId(check.get("email")));
        }

        if (check.containsKey("classYear")) {
            userChanging.setUser_id(new ObjectId(check.get("clearYear")));
        }

        if (check.containsKey("major")) {
            userChanging.setUser_id(new ObjectId(check.get("major")));
        }

        if (check.containsKey("wishList")) {
            userChanging.setUser_id(new ObjectId(check.get("wishList")));
        }

        if (check.containsKey("registrationComplete")) {
            userChanging.setUser_id(new ObjectId(check.get("registrationComplete")));
        }

        return userChanging;
    }
}
