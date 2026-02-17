package eci.edu.co.reviews_service.service;

import eci.edu.co.reviews_service.dto.ReviewRequestDTO;
import eci.edu.co.reviews_service.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {
    
    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO);
    
    List<ReviewResponseDTO> getAllReviews();
    
    ReviewResponseDTO getReviewById(String id);
    
    void deleteReview(String id);
    
    List<ReviewResponseDTO> getReviewsByRestaurantId(String restaurantId);
    
    List<ReviewResponseDTO> getReviewsByUserId(String userId);
}
