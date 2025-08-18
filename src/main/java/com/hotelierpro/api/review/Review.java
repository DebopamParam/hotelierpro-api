package com.hotelierpro.api.review;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// 1. @Document marks this class as a MongoDB document model.
//    We explicitly name the collection "reviews".
@Document(collection = "reviews")
public class Review {

    // 2. @Id marks this field as the primary key (_id in MongoDB).
    //    Because it's a String, MongoDB will auto-generate an ObjectId.
    @Id
    private String id;

    // We'll store the ID of the hotel this review is for.
    // This is how we link back to our relational data.
    private Long hotelId;

    // The rating, from 1 to 5.
    private int rating;

    // The text content of the review.
    private String comment;

    // The name of the user who left the review.
    private String userName;

    // A no-argument constructor is needed for the mapping framework.
    public Review() {
    }

    // Getters and Setters for all fields.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
