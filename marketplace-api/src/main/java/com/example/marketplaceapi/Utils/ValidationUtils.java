package com.example.marketplaceapi.Utils;

import com.example.marketplaceapi.MarketplaceApiApplication;
import com.example.marketplaceapi.database.User;
import com.example.marketplaceapi.exceptions.SvcException;
import com.example.marketplaceapi.services.DatabaseServices;

public class ValidationUtils {

    public static void validateCreateUser(final User pUser) throws SvcException{
        if(pUser == null){
            throw new SvcException("User is null");
        }


            throw new SvcException("User already exists");
        }
    }

    //Sai Kuchulakanti and Jamey Denninger
    //Validation Method for User
    public static void validateUser (final User pPreviousUser) throws SvcException {
        if (!(DatabaseServices.findUserById(pPreviousUser.getUser_id()).isPresent())) {
            throw new SvcException("User does not exist in the database");
        }
    }


}
