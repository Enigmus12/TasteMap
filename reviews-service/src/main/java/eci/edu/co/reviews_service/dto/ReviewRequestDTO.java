package eci.edu.co.reviews_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {
    
    private String userId;
    
    private String restaurantId;
    
    private String comment;
    
    private Integer stars;
}
