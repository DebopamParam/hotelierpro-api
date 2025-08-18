package com.hotelierpro.api.hotel;

import com.hotelierpro.api.room.Room; // Import the new Room entity
import jakarta.persistence.*; // Import additional annotations

import java.util.ArrayList; // Import List and ArrayList
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    // This is the "One" side of the relationship.
    // mappedBy = "hotel" tells JPA that the 'hotel' field in the Room entity manages this relationship.
    // cascade = CascadeType.ALL means operations on Hotel will cascade to its Rooms.
    // orphanRemoval = true means if a Room is removed from this list, it should be deleted from the database.
    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Room> rooms = new ArrayList<>(); // New field for the rooms

    // JPA requires a no-argument constructor
    public Hotel() {
    }

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters and Setters for all fields, including the new 'rooms' list
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Helper methods to manage the relationship safely
    public void addRoom(Room room) {
        rooms.add(room);
        room.setHotel(this);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
        room.setHotel(null);
    }
}
