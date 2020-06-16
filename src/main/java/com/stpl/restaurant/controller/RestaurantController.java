package com.stpl.restaurant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.stpl.restaurant.model.Restaurant;
import com.stpl.restaurant.service.RestaurantService;

@RestController
public class RestaurantController {

  @Autowired
  private RestaurantService restaurantService;
  
  @PostMapping("/restaurant")
  public void add(@RequestBody Restaurant restaurant) {
    restaurantService.save(restaurant);
  }
  
  @GetMapping("/restaurant")
  public List<Restaurant> get() {
    return restaurantService.findAll();
  }
}
