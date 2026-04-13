package com.tap.foodDAO;

import java.util.List;

import com.foodapp.models.Restaurant;


public interface RestaurantDAO {
	
	public List<Restaurant> getAllRestaurant();
	public Restaurant getRestaurantByid(int restaurantid);
	public void addRestaurant(Restaurant r);
	public void updateRestaurant(Restaurant r);
	public void deleteRestaurant(int restaurantid);

	

}
