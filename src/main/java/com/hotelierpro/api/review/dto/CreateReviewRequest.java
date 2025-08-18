package com.hotelierpro.api.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateReviewRequest {
    @NotNull(message = "Hotel ID can't be null.")
    private Long hotelId;
    @Min(value = 1, message = "Rating must be atleast 1.")
    @Max(value = 5, message = "RAting must be atmost 5.")
    private int rating;
    private String comment;//this is optional so no validation required
    @NotBlank(message = "username can not be blank.")
    private String userName;

    // Getters and Setters
    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
