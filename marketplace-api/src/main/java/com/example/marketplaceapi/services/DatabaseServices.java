package com.example.marketplaceapi.services;

import com.example.marketplaceapi.MarketplaceApiApplication;

import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.CompletedListing;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.*;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     *
     * @param pUserId
     * @return User with the correct id or an empty Optional
     */
    public static Optional<User> findUserById(final ObjectId pUserId){
        return MarketplaceApiApplication.visableUserRepo
                .findAll()
                .stream()
                .filter(user -> user.getUser_id().equals(pUserId))
                .findFirst();
    }

    /**
     *
     * @param pActiveListingId
     * @return ActiveListing with the correct id or an empty Optional
     */
    public static Optional<ActiveListing> findActiveListingById(final ObjectId pActiveListingId){
        return MarketplaceApiApplication.visableActiveListingRepo
                .findAll()
                .stream()
                .filter(activeListing -> activeListing.getListing_id().equals(pActiveListingId))
                .findFirst();
    }

    /**
     *
     * @param pCompletedListing
     * @return CompletedListing with the correct id or an empty Optional
     */
    public static Optional<CompletedListing> findCompletedListingById(final ObjectId pCompletedListing){
        return MarketplaceApiApplication.visableCompletedListingRepo
                .findAll()
                .stream()
                .filter(completedListing -> completedListing.getListing_id().equals(pCompletedListing))
                .findFirst();
    }

    public static void saveUser(final User pUser) throws DatabaseException{
        try {
            MarketplaceApiApplication.visableUserRepo.save(pUser);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new DatabaseException("Issue saving user: " +pUser.toString());
        }
    }

    public static void saveActiveListing(final ActiveListing pActiveListing) throws DatabaseException {
        try {
            MarketplaceApiApplication.visableActiveListingRepo.save(pActiveListing);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Issue saving active listing: " +pActiveListing.toString());
        }
    }

    public static void saveCompletedListing(final CompletedListing pCompletedListing) throws DatabaseException {
        try {
            MarketplaceApiApplication.visableCompletedListingRepo.save(pCompletedListing);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Issue saving completed listing: " +pCompletedListing.toString());
        }
    }

    public static void deleteUser(final User pUser) throws DatabaseException {
        try {
            MarketplaceApiApplication.visableUserRepo.delete(pUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Issue deleting user: " +pUser.toString());
        }
    }

    public static void deleteActiveListing(final ActiveListing pActiveListing) throws DatabaseException {
        try {
            MarketplaceApiApplication.visableActiveListingRepo.delete(pActiveListing);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Issue deleting active listing: " +pActiveListing.toString());
        }
    }
    /**
    This method is used to return a list of all users that are present in the database
    input -> no input
    output -> a List<User> containing all users present in the database
     */
    public static List<User> getAllUsers(){

        return new ArrayList<>(MarketplaceApiApplication.visableUserRepo.findAll());
    }

    // Jamey Denninger
    public static void deleteCompletedListing (final CompletedListing pCompletedListing){
        try{
            MarketplaceApiApplication.visableUserRepo.findAll().delete(pCompletedListing);
        }
        catch (execption e) {
            e.printStackTrace();
            throw new DatabaseException("Issue deleting completed listing: " +pCompletedListing.toString());
        }

    }
}
