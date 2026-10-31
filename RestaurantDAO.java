package com.tap.DAO;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {
	void addRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(int RestaurantID);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(int RestaurantID);

    List<Restaurant> getAllRestaurant();

}
