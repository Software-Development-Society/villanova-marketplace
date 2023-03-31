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



    // example get method
    public ObjectId getUser_id() {

        return user_id;
    }
    // add get methods here


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getClassYear() {
        return classYear;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<ObjectId> getWishList() {
        return wishList;
    }

    public boolean isRegistrationComplete() {
        return registrationComplete;
    }

    // example set method
    public void setUser_id(ObjectId user_id) {
        this.user_id = user_id;

    }
    // add set methods here
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setWishList(ArrayList<ObjectId> wishList) {
        this.wishList = wishList;
    }

    public void setRegistrationComplete(boolean registrationComplete) {
        this.registrationComplete = registrationComplete;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", classYear=" + classYear +
                ", major='" + major + '\'' +
                ", wishList=" + wishList +
                '}';
    }



}
