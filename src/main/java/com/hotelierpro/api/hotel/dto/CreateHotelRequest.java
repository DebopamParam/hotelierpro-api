package com.hotelierpro.api.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateHotelRequest {
    @NotBlank(message = "Hotel name can not be blank")
    @Size(min=3, max=100, message = "Hotel name must be between 3 and 100 characters.")
    private String name;
    @NotBlank(message = "City name can not be blank.")
    private String city;

    //getter an setter

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
