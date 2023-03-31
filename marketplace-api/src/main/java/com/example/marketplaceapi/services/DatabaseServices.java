package com.example.marketplaceapi.services;

import com.example.marketplaceapi.MarketplaceApiApplication;

import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.CompletedListing;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.GetActiveListingException;
import com.example.marketplaceapi.exceptions.GetCompletedListingException;
import com.example.marketplaceapi.exceptions.GetUserException;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;

public class DatabaseServices {


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



    /*
    This method is used to return a list of all users that are present in the database
    input -> no input
    output -> a List<User> containing all users present in the database
     */
    public static List<User> getAllUsers(){

        return new ArrayList<>(MarketplaceApiApplication.visableUserRepo.findAll());
    }


    /*
    This method is used to retrieve a specific user from the database by user_id
    input -> (ObjectId) user_id that is the users id in the db
    output -> User that is the user corresponding with that id
    Exception -> throws GetUserException when the wanted user_id is not present in the database
     */
    public static User getUser(ObjectId user_id) throws GetUserException {
        for (User user : MarketplaceApiApplication.visableUserRepo.findAll()) {
            if (user.getUser_id().equals(user_id)) {
                return user;
            }
        }
        throw new GetUserException("User with id: " +user_id+ " does not exist in the database.");
    }

    public static void deleteActiveListing (ObjectId listing_id) throws GetActiveListingException {
        MarketplaceApiApplication.visableActiveListingRepo.delete(getActiveListing(listing_id));
    }

    public static ActiveListing getActiveListing(ObjectId listing_id) throws GetActiveListingException {
        for (ActiveListing activeListing : MarketplaceApiApplication.visableActiveListingRepo.findAll()) {
            if (activeListing.getListing_id().equals(listing_id)) {
                return activeListing;
            }
        }
        throw new GetActiveListingException("Active listing with id: " +listing_id+ " does not exist in the database.");
    }

    public static void saveUser(User user){
        try {
            MarketplaceApiApplication.visableUserRepo.save(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static CompletedListing getCompletedListing(ObjectId listing_id) throws GetCompletedListingException {
        for(CompletedListing completedListing : MarketplaceApiApplication.visableCompletedListingRepo.findAll()){
            if(completedListing.getListing_id().equals(listing_id)){
                return completedListing;
            }
        }
        throw new GetCompletedListingException("Completed listing with id: " +listing_id+ " does not exist in the database.");
    }

    /**
     *
     * @param user The User Object that should be deleted
     */
    public static void deleteUser(User user) throws GetUserException{
        try {
            MarketplaceApiApplication.visableUserRepo.delete(user);
        }

        catch (Exception e) {
            e.printStackTrace();
            throw new GetUserException("The User " + " " + user + " " + " was not successfully deleted.");
        }
    }










}
