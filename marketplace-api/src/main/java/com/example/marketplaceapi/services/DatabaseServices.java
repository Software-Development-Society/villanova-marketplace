package com.example.marketplaceapi.services;

import com.example.marketplaceapi.MarketplaceApiApplication;

import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.CompletedListing;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.GetActiveListingException;
import com.example.marketplaceapi.exceptions.GetCompletedListingException;
import com.example.marketplaceapi.exceptions.GetUserException;
import com.example.marketplaceapi.exceptions.UserException;
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



    /**
    This method is used to return a list of all users that are present in the database
    input -> no input
    output -> a List<User> containing all users present in the database
     */
    public static List<User> getAllUsers(){

        return new ArrayList<>(MarketplaceApiApplication.visableUserRepo.findAll());
    }


    /**
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

    /**
     *
     * @param listing_id -> ObjectId containing the listing_id for the user that is wanted
     * @return -> returns the active listing corresponding with that listing_id
     * @throws GetActiveListingException -> throws exception if listing does not exist
     */
    public static ActiveListing getActiveListing(ObjectId listing_id) throws GetActiveListingException {
        for (ActiveListing activeListing : MarketplaceApiApplication.visableActiveListingRepo.findAll()) {
            if (activeListing.getListing_id().equals(listing_id)) {
                return activeListing;
            }
        }
        throw new GetActiveListingException("Active listing with id: " +listing_id+ " does not exist in the database.");
    }

    /**
     *
     * @param user -> user obect containing the user that is to be saved
     * returns -> void
     * @throws UserException -> exception occurs if there is an issue saving the user.
     */
    public static void saveUser(User user) throws UserException {
        try {
            MarketplaceApiApplication.visableUserRepo.save(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new UserException("Issue Saving user: " +user.toString());
        }
    }

    /**
     * @param listing_id -> ObjectId containing a completed listing that is to be retrieved
     * @return -> a completed listing corresponding with the given listing_id
     * @throws GetCompletedListingException -> throws exception if listing is not present in the database.
     */




    /**
    This method is used to delete a specific listing from the database
    input -> (ObjectId) listing_id that is the users id in the db
    output -> void
    Exception -> throws getActiveListingException when the wanted listing_id is not present in the database
     */
    public static void deleteActiveListing (ObjectId listing_id) throws GetActiveListingException {
        try{
            MarketplaceApiApplication.visableActiveListingRepo.delete(getActiveListing(listing_id));
        }
        catch (Exception e){
            e.printStackTrace();
            throw new GetActiveListingException("Listing with id: " +listing_id+ " was not successfully deleted.");
        }

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

    /**
     *
     * @param listing_id the listing id of a completed listing
     * @return the completed listing of the object with the listing id
     * @throws GetCompletedListingException when there isn't a Completed listing object with the listing id input
     */
    public static CompletedListing getCompletedListing(ObjectId listing_id) throws GetCompletedListingException {
        for(CompletedListing completedListing : MarketplaceApiApplication.visableCompletedListingRepo.findAll()){
            if(completedListing.getListing_id().equals(listing_id)){
                return completedListing;
            }
        }
        throw new GetCompletedListingException("Completed listing with id: " +listing_id+ " does not exist in the database.");
    }












}
