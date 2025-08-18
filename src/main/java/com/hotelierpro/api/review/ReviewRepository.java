package com.hotelierpro.api.review;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// We extend MongoRepository, specifying the Document type (Review) and the ID type (String).
public interface ReviewRepository extends MongoRepository<Review, String> {

    // This is a custom derived query.
    // Spring Data MongoDB will automatically implement this method for us.
    // It will find all Review documents where the 'hotelId' field matches the given parameter.
    List<Review> findByHotelId(Long hotelId);
}
