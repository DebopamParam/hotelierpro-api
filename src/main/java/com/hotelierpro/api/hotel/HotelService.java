package com.hotelierpro.api.hotel;
//this DTO represents the data we will RECEIVE from the client to create a hotel.

import com.hotelierpro.api.errors.ResourceNotFoundException;
import com.hotelierpro.api.hotel.dto.CreateHotelRequest;
import com.hotelierpro.api.hotel.dto.HotelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }

   public HotelDto createHotel(CreateHotelRequest request){
        Hotel hotel= new Hotel(request.getName(),request.getCity());
        Hotel savedHotel = hotelRepository.save(hotel);
       System.out.println("Saved hotel with ID: "+savedHotel.getId());

       return mapToHotelDto(savedHotel);
    }
    public List<HotelDto> getHotels(){
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream().map(this::mapToHotelDto).toList();
    }
    public HotelDto getHotelById(Long hotelId) {
        // Find the hotel entity from the repository.
        Hotel hotel = hotelRepository.findById(hotelId)
                // If the hotel is not found, throw our custom exception.
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));

        // If found, map it to a DTO and return it.
        return mapToHotelDto(hotel);
    }
    /*public HotelDto getHotelById(Long hotelId){
        Optional<Hotel> hotelOptional=hotelRepository.findById(hotelId);
        return hotelOptional.map(this::mapToHotelDto).orElse(null);
    }*/

    private HotelDto mapToHotelDto(Hotel hotel) {
        HotelDto dto = new HotelDto();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setCity(hotel.getCity());
        return dto;
    }
}
