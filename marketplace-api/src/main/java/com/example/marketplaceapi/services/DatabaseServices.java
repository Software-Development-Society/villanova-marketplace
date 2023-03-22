package com.example.marketplaceapi.services;

import com.example.marketplaceapi.MarketplaceApiApplication;

import com.example.marketplaceapi.database.User;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;

public class DatabaseServices {


    public static List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();

        for(User user : MarketplaceApiApplication.visableUserRepo.findAll()){
            users.add(user);
        }
        return users;
    }

    public static User getUser (ObjectId user_id) {
        ObjectId target = user_id;
        for (User user : MarketplaceApiApplication.visableUserRepo.findAll()) {
            if (user.getUser_id().equals(user_id)) {
                return user;
            }
        }
        System.out.println("User not in database.");
        return new User();
    }










































































































































































//    // EXAMPLE METHOD TO GET STUDENT FROM DATABASE
//    public static Student getStudentUsingId(ObjectId user_id){
//        // for each loop to get each student from the db
//        for(Student student : visableStudentRepo.findAll()){
//            // compare the current id to the target id
//            if(student.getStudentId().equals(user_id)){
//                return student;
//            }
//
//        }
//        // if it gets here there are big problems
//        System.out.println("There is no student with id: " +user_id);
//        return new Student();
//    }







}
