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
        user = new User(user_id, firstName, lastName, email, classYear, major, wishList);
    }

    @AfterEach
    void tearDown() {
        user = null;
    }

    @Test
    void getUser_id() {
        assertEquals(user.getUser_id(), user_id);
    }

    @Test
    void getFirstName() {
        assertEquals(user.getFirstName(), firstName);
    }

    @Test
    void getLastName() {
        assertEquals(user.getLastName(), lastName);
    }

    @Test
    void getEmail() {
        assertEquals(user.getEmail(), email);
    }

    @Test
    void getClassYear() {
        assertEquals(user.getClassYear(), classYear);
    }

    @Test
    void getMajor() {
        assertEquals(user.getMajor(), major);
    }

    @Test
    void getWishList() {
        assertEquals(user.getWishList(), wishList);
    }

    @Test
    void isRegistrationComplete() {
        assertFalse(user.isRegistrationComplete());// Assuming registration is not complete by default
    }

    @Test
    void setUser_id() {
        ObjectId newUser_id = new ObjectId("6418a473b1aaafbd1171c2f7");
        user.setUser_id(newUser_id);
        assertEquals(user.getUser_id(), newUser_id);
    }

    @Test
    void setFirstName() {
        String newFirstName = "John";
        user.setFirstName(newFirstName);
        assertEquals(user.getFirstName(), newFirstName);
    }

    @Test
    void setLastName() {
        String newLastName = "Doe";
        user.setLastName(newLastName);
        assertEquals(user.getLastName(), newLastName);
    }

    @Test
    void setEmail() {
        String newEmail = "jdoe@villanova.edu";
        user.setEmail(newEmail);
        assertEquals(user.getEmail(), newEmail);
    }

    @Test
    void setClassYear() {
        int newClassYear = 2024;
        user.setClassYear(newClassYear);
        assertEquals(user.getClassYear(), newClassYear);
    }

    @Test
    void setMajor() {
        String newMajor = "Computer Science";
        user.setMajor(newMajor);
        assertEquals(user.getMajor(), newMajor);
    }

    @Test
    void setWishList() {
        ArrayList<ObjectId> newWishList = new ArrayList<>();
        newWishList.add(new ObjectId("6418a473b1aaafbd1171c2f7"));
        user.setWishList(newWishList);
        assertEquals(user.getWishList(), newWishList);
    }
    }

    @Test
    void setRegistrationComplete() {
        user.setRegistrationComplete(true);
        assertTrue(user.isRegistrationComplete());
    }

    @Test
    void testToString() {
        String expectedString = "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", classYear=" + classYear +
                ", major='" + major + '\'' +
                ", wishList=" + wishList +
                '}';
        assertEquals(user.toString(), expectedString);
    }
}