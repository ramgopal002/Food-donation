package com.stpl.restaurant.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stpl.restaurant.model.Restaurant;
import com.stpl.restaurant.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantService {

  @Autowired
  public RestaurantRepository restaurantRepository;


  public List<Restaurant> findAll() {
    return restaurantRepository.findAll();
  }

  public void save(Restaurant product) {
    restaurantRepository.save(product);
  }
}
