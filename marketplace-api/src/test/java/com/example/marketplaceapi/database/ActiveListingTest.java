package com.example.marketplaceapi.database;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActiveListingTest {

    private ActiveListing activeListing;

    @BeforeEach
    void setUp() {
        ArrayList<Binary> pictures = new ArrayList<>();
        pictures.add(new Binary(new byte[]{1, 2, 3}));
        pictures.add(new Binary(new byte[]{4, 5, 6}));

        ArrayList<String> tags = new ArrayList<>();
        tags.add("electronics");
        tags.add("gadgets");

        activeListing = new ActiveListing(new ObjectId(), "Test Product", "A test product description", 100, pictures, "John Doe", new ObjectId(), tags, 0, "new", new Date());
    }

    @Test
    void getListing_id() {
        ObjectId expectedListingId = activeListing.getListing_id();
        assertEquals(expectedListingId, activeListing.getListing_id());
    }

    @Test
    void getProductName() {
        String expectedProductName = "Test Product";
        assertEquals(expectedProductName, activeListing.getProductName());
    }

    @Test
    void getDescription() {
        String expectedDescription = "A test product description";
        assertEquals(expectedDescription, activeListing.getDescription());
    }

    @Test
    void getPrice() {
        int expectedPrice = 100;
        assertEquals(expectedPrice, activeListing.getPrice());
    }

    @Test
    void getPictures() {
        ArrayList<Binary> expectedPictures = activeListing.getPictures();
        assertEquals(expectedPictures, activeListing.getPictures());
    }

    @Test
    void getSellerName() {
        String expectedSellerName = "John Doe";
        assertEquals(expectedSellerName, activeListing.getSellerName());
    }

    @Test
    void getSeller_id() {
        ObjectId expectedSellerId = activeListing.getSeller_id();
        assertEquals(expectedSellerId, activeListing.getSeller_id());
    }

    @Test
    void getTags() {
        ArrayList<String> expectedTags = activeListing.getTags();
        assertEquals(expectedTags, activeListing.getTags());
    }

    @Test
    void getViews() {
        int expectedViews = 0;
        assertEquals(expectedViews, activeListing.getViews());
    }

    @Test
    void getCondition() {
        String expectedCondition = "new";
        assertEquals(expectedCondition, activeListing.getCondition());
    }

    @Test
    void getDateAdded() {
        Date expectedDateAdded = activeListing.getDateAdded();
        assertEquals(expectedDateAdded, activeListing.getDateAdded());
    }

}
