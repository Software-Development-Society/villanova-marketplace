package com.example.marketplaceapi.Utils;

import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.SvcException;
import com.example.marketplaceapi.services.DatabaseServices;

public class ValidationUtils {

    public static void validateCreateUser(final User pUser) throws SvcException{
        if(pUser == null){
            throw new SvcException("User is null");
        }

        if (DatabaseServices.findUserById(pUser.getUser_id()).isPresent()){
            throw new SvcException("User already exists");
        }
    }

    public static void validateCreateActiveListing(final ActiveListing pActiveListing) throws SvcException{
        if(pActiveListing == null){
            throw new SvcException("Active Listing is null");
        }

        if (DatabaseServices.findActiveListingById(pActiveListing.getListing_id()).isPresent()){
            throw new SvcException("Active Listing already exists");
        }
    }
}
