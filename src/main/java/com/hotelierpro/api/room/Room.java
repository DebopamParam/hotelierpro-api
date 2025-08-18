package com.hotelierpro.api.room;

import com.hotelierpro.api.hotel.Hotel;
import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "type", nullable = false)
    private String type; // e.g., "Single", "Double", "Suite"

    @Column(name = "price", nullable = false)
    private double price;

    // This is the "Many" side of the relationship.
    @ManyToOne(fetch = FetchType.LAZY)
    // This specifies the foreign key column in the 'rooms' table.
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    // No-arg constructor for JPA
    public Room() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
