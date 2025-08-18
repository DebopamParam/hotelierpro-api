package com.hotelierpro.api.review;

import com.hotelierpro.api.review.dto.CreateReviewRequest;
import com.hotelierpro.api.review.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewDto createReview(CreateReviewRequest request) {
        Review review = new Review();
        review.setHotelId(request.getHotelId());
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setUserName(request.getUserName());

        Review savedReview = reviewRepository.save(review);
        return mapToDto(savedReview);
    }

    public List<ReviewDto> getReviewsForHotel(Long hotelId) {
        // Use our custom derived query method
        List<Review> reviews = reviewRepository.findByHotelId(hotelId);
        return reviews.stream().map(this::mapToDto).toList();
    }

    private ReviewDto mapToDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setHotelId(review.getHotelId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        dto.setUserName(review.getUserName());
        return dto;
    }
}
