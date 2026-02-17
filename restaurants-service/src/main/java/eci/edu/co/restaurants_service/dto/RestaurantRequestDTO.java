package eci.edu.co.restaurants_service.dto;

import eci.edu.co.restaurants_service.model.RestaurantType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDTO {

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
