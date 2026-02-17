package eci.edu.co.reviews_service.service;

import eci.edu.co.reviews_service.dto.ReviewRequestDTO;
import eci.edu.co.reviews_service.dto.ReviewResponseDTO;
import eci.edu.co.reviews_service.model.Review;
import eci.edu.co.reviews_service.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    private final ReviewRepository reviewRepository;
    
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = new Review();
        review.setUserId(reviewRequestDTO.getUserId());
        review.setRestaurantId(reviewRequestDTO.getRestaurantId());
        review.setComment(reviewRequestDTO.getComment());
        review.setStars(reviewRequestDTO.getStars());
        review.setLikes(0);
        review.setDislikes(0);
        review.setCreatedAt(LocalDateTime.now());
        
        Review savedReview = reviewRepository.save(review);
        return mapToResponseDTO(savedReview);
    }
    
    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public ReviewResponseDTO getReviewById(String id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        return mapToResponseDTO(review);
    }
    
    @Override
    public void deleteReview(String id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }
    
    @Override
    public List<ReviewResponseDTO> getReviewsByRestaurantId(String restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<ReviewResponseDTO> getReviewsByUserId(String userId) {
        return reviewRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    
    private ReviewResponseDTO mapToResponseDTO(Review review) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUserId());
        dto.setRestaurantId(review.getRestaurantId());
        dto.setComment(review.getComment());
        dto.setStars(review.getStars());
        dto.setLikes(review.getLikes());
        dto.setDislikes(review.getDislikes());
        dto.setCreatedAt(review.getCreatedAt());
        return dto;
    }
}
