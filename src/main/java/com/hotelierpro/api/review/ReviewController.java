package com.hotelierpro.api.review;

import com.hotelierpro.api.review.dto.CreateReviewRequest;
import com.hotelierpro.api.review.dto.ReviewDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewDto createReview(@Valid @RequestBody CreateReviewRequest request) {
        return reviewService.createReview(request);
    }

    // Example: GET /api/reviews?hotelId=1
    @GetMapping
    public List<ReviewDto> getReviews(@RequestParam Long hotelId) {
        return reviewService.getReviewsForHotel(hotelId);
    }
}
