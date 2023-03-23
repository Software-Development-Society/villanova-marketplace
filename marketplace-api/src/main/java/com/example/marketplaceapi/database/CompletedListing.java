package com.example.marketplaceapi.database;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "completedlistings")
public class CompletedListing {
    @Id
    private ObjectId listing_id;

    @Field
    private ObjectId transaction_id;

    @Field
    private String productName;

    @Field
    private String description;

    @Field
    private int price;

    @Field
    private ArrayList<Binary> pictures;

    @Field
    private String sellerName;

    @Field
    private ObjectId seller_id;

    @Field
    private ArrayList<String> tags;

    @Field
    private int views;

    @Field
    private String condition;

    @Field
    private Date dateAdded;

    @Field
    private ObjectId soldToId;

    @Field
    private Date dateSold;




    public CompletedListing() {
    }

    public CompletedListing(ObjectId listing_id, ObjectId transaction_id, String productName, String description, int price, ArrayList<Binary> pictures, String sellerName, ObjectId seller_id, ArrayList<String> tags, int views, String condition, Date dateAdded, ObjectId soldToId, Date dateSold) {
        this.listing_id = listing_id;
        this.transaction_id = transaction_id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.pictures = pictures;
        this.sellerName = sellerName;
        this.seller_id = seller_id;
        this.tags = tags;
        this.views = views;
        this.condition = condition;
        this.dateAdded = dateAdded;
        this.soldToId = soldToId;
        this.dateSold = dateSold;
    }


    // example get method

    public ObjectId getListing_id() {
        return listing_id;
    }
    // add get methods here


    public ObjectId getTransaction_id() {
        return transaction_id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Binary> getPictures() {
        return pictures;
    }

    public String getSellerName() {
        return sellerName;
    }

    public ObjectId getSeller_id() {
        return seller_id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public int getViews() {
        return views;
    }

    public String getCondition() {
        return condition;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public ObjectId getSoldToId() {
        return soldToId;
    }

    public Date getDateSold() {
        return dateSold;
    }

    // example set method
    public void setListing_id(ObjectId listing_id) {
        this.listing_id = listing_id;
    }
    // add set methods here
    public void setTransaction_id(ObjectId transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPictures(ArrayList<Binary> pictures) {
        this.pictures = pictures;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSeller_id(ObjectId seller_id) {
        this.seller_id = seller_id;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setSoldToId(ObjectId soldToId) {
        this.soldToId = soldToId;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }


    @Override
    public String toString() {
        return "CompletedListing{" +
                "listing_id=" + listing_id +
                ", transaction_id=" + transaction_id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pictures=" + pictures +
                ", sellerName='" + sellerName + '\'' +
                ", seller_id=" + seller_id +
                ", tags=" + tags +
                ", views=" + views +
                ", condition='" + condition + '\'' +
                ", dateAdded=" + dateAdded +
                ", soldToId=" + soldToId +
                ", dateSold=" + dateSold +
                '}';
    }

}
