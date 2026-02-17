package eci.edu.co.restaurants_service.service;

import eci.edu.co.restaurants_service.dto.RestaurantRequestDTO;
import eci.edu.co.restaurants_service.dto.RestaurantResponseDTO;
import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    RestaurantResponseDTO createRestaurant(RestaurantRequestDTO request);

    List<RestaurantResponseDTO> getAllRestaurants();

    Optional<RestaurantResponseDTO> getRestaurantById(String id);

    Optional<RestaurantResponseDTO> updateRestaurant(String id, RestaurantRequestDTO request);

    boolean deleteRestaurant(String id);
}
