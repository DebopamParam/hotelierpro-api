package com.hotelierpro.api.hotel;

import com.hotelierpro.api.hotel.dto.CreateHotelRequest;
import com.hotelierpro.api.hotel.dto.HotelDto;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    // Inject the service using constructor injection
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelDto> getHotels() {
        // The controller delegates all work to the service.
        return hotelService.getHotels();
    }

    @GetMapping("/{hotelId}")
    public HotelDto getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping
    public HotelDto createHotel(@Valid @RequestBody CreateHotelRequest request) {
        // The controller receives a DTO and passes it to the service.
        // It receives a DTO back and returns it.
        return hotelService.createHotel(request);
    }
}
