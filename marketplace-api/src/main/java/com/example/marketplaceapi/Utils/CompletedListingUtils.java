package com.example.marketplaceapi.Utils;

import com.example.marketplaceapi.database.ActiveListing;
import com.example.marketplaceapi.database.CompletedListing;
import com.example.marketplaceapi.database.User;

import java.util.Date;

public class CompletedListingUtils {

    public CompletedListing activeListingToCompletedListing (final ActiveListing pActiveListing, final User pUser) {
        CompletedListing newCompletedListing = new CompletedListing();

        newCompletedListing.setListing_id(pActiveListing.getListing_id());
        newCompletedListing.setTransaction_id(newCompletedListing.getTransaction_id());
        newCompletedListing.setProductName(pActiveListing.getProductName());
        newCompletedListing.setDescription(pActiveListing.getDescription());
        newCompletedListing.setPrice(pActiveListing.getPrice());
        newCompletedListing.setPictures(pActiveListing.getPictures());
        newCompletedListing.setSellerName(pActiveListing.getSellerName());
        newCompletedListing.setSeller_id(pActiveListing.getSeller_id());
        newCompletedListing.setTags(pActiveListing.getTags());
        newCompletedListing.setViews(pActiveListing.getViews());
        newCompletedListing.setCondition(pActiveListing.getCondition());
        newCompletedListing.setDateAdded(pActiveListing.getDateAdded());
        newCompletedListing.setSoldToId(pUser.getUser_id());
        newCompletedListing.setDateSold(new Date());

        return newCompletedListing;

    }


}
