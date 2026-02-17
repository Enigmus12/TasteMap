package eci.edu.co.reviews_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {
    
    private String id;
    
    private String userId;
    
    private String restaurantId;
    
    private String comment;
    
    private Integer stars;
    
    private Integer likes;
    
    private Integer dislikes;
    
    private LocalDateTime createdAt;
}
