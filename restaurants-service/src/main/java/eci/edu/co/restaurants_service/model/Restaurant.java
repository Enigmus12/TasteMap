package eci.edu.co.restaurants_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "restaurants")
public class Restaurant {

    @Id
    private String id;
    private String name;
    private String description;
    private String location;
    private String specialty;
    private String logoUrl;
    private String openingHours;
    private Boolean hasReservation;
    private RestaurantType type;
    private String priceRange;
    private String menuLink;
    private Double averageRating;
    private Integer reviewsCount;
}
