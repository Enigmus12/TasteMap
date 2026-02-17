package eci.edu.co.restaurants_service.service;

import eci.edu.co.restaurants_service.dto.RestaurantRequestDTO;
import eci.edu.co.restaurants_service.dto.RestaurantResponseDTO;
import eci.edu.co.restaurants_service.model.Restaurant;
import eci.edu.co.restaurants_service.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantResponseDTO createRestaurant(RestaurantRequestDTO request) {
        Restaurant restaurant = toEntity(request);
        Restaurant saved = restaurantRepository.save(restaurant);
        return toResponse(saved);
    }

    @Override
    public List<RestaurantResponseDTO> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RestaurantResponseDTO> getRestaurantById(String id) {
        return restaurantRepository.findById(id)
                .map(this::toResponse);
    }

    @Override
    public Optional<RestaurantResponseDTO> updateRestaurant(String id, RestaurantRequestDTO request) {
        return restaurantRepository.findById(id)
                .map(existing -> {
                    applyUpdates(existing, request);
                    Restaurant saved = restaurantRepository.save(existing);
                    return toResponse(saved);
                });
    }

    @Override
    public boolean deleteRestaurant(String id) {
        if (!restaurantRepository.existsById(id)) {
            return false;
        }
        restaurantRepository.deleteById(id);
        return true;
    }

    private Restaurant toEntity(RestaurantRequestDTO request) {
        return Restaurant.builder()
                .name(request.getName())
                .description(request.getDescription())
                .location(request.getLocation())
                .specialty(request.getSpecialty())
                .logoUrl(request.getLogoUrl())
                .openingHours(request.getOpeningHours())
                .hasReservation(request.getHasReservation())
                .type(request.getType())
                .priceRange(request.getPriceRange())
                .menuLink(request.getMenuLink())
                .averageRating(request.getAverageRating())
                .reviewsCount(request.getReviewsCount())
                .build();
    }

    private void applyUpdates(Restaurant target, RestaurantRequestDTO request) {
        target.setName(request.getName());
        target.setDescription(request.getDescription());
        target.setLocation(request.getLocation());
        target.setSpecialty(request.getSpecialty());
        target.setLogoUrl(request.getLogoUrl());
        target.setOpeningHours(request.getOpeningHours());
        target.setHasReservation(request.getHasReservation());
        target.setType(request.getType());
        target.setPriceRange(request.getPriceRange());
        target.setMenuLink(request.getMenuLink());
        target.setAverageRating(request.getAverageRating());
        target.setReviewsCount(request.getReviewsCount());
    }

    private RestaurantResponseDTO toResponse(Restaurant restaurant) {
        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .description(restaurant.getDescription())
                .location(restaurant.getLocation())
                .specialty(restaurant.getSpecialty())
                .logoUrl(restaurant.getLogoUrl())
                .openingHours(restaurant.getOpeningHours())
                .hasReservation(restaurant.getHasReservation())
                .type(restaurant.getType())
                .priceRange(restaurant.getPriceRange())
                .menuLink(restaurant.getMenuLink())
                .averageRating(restaurant.getAverageRating())
                .reviewsCount(restaurant.getReviewsCount())
                .build();
    }
}
