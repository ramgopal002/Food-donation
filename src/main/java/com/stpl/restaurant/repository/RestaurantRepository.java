package com.stpl.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stpl.restaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}
