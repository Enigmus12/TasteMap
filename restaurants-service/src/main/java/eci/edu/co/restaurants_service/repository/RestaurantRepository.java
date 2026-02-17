package eci.edu.co.restaurants_service.repository;

import eci.edu.co.restaurants_service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
