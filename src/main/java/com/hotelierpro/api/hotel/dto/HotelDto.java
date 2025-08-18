package com.hotelierpro.api.hotel.dto;

// This DTO represents the data we will SEND to the client.
public class HotelDto {
    private Long id;
    private String name;
    private String city;

    // Getters and Setters are needed for mapping
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
