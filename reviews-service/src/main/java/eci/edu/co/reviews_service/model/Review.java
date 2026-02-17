package eci.edu.co.reviews_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    
    @Id
    private String id;
    
    private String userId;
    
    private String restaurantId;
    
    private String comment;
    
    private Integer stars;
    
    private Integer likes;
    
    private Integer dislikes;
    
    private LocalDateTime createdAt;
}
