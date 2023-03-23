package com.example.marketplaceapi.database;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    ObjectId user_id = new ObjectId("6418a40840df1c5c12652b1d");
    String firstName = "John";
    String lastName = "Doe";
    String email = "jdoe@villanova.edu";
    int classYear = 2024;
    String major = "Computer Science";
    ArrayList<ObjectId> wishList = new ArrayList<>();
    User user = new User(user_id,firstName,lastName,email,classYear,major,wishList);


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser_id() {
        assertEquals(user.getUser_id(), user_id);
    }

    @Test
    void getFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getClassYear() {
    }

    @Test
    void getMajor() {
    }

    @Test
    void getWishList() {
    }

    @Test
    void isRegistrationComplete() {
    }

    @Test
    void setUser_id() {
        ObjectId newUser_id = new ObjectId("6418a473b1aaafbd1171c2f7");
        user.setUser_id(newUser_id);
        assertEquals(user.getUser_id(), newUser_id);
    }

    @Test
    void setFirstName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setClassYear() {
    }

    @Test
    void setMajor() {
    }

    @Test
    void setWishList() {
    }

    @Test
    void setRegistrationComplete() {
    }

    @Test
    void testToString() {
    }
}