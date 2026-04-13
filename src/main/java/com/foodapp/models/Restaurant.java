package com.foodapp.models;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String address;
	private String rating;
	private String cuisine;
	private int deliveryTime;
	private String isActive;
	private String imageurl;
	private int adminUserId;
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String restaurantName, String address, String rating, String cuisine,
			int deliveryTime, String isActive, String imageurl, int adminUserId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.rating = rating;
		this.cuisine = cuisine;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.imageurl = imageurl;
		this.adminUserId = adminUserId;
	}
	public Restaurant(int restaurantId, String restaurantName, String address, String rating, String cuisine,
		            String isActive, String imageurl, int adminUserId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.rating = rating;
		this.cuisine = cuisine;
		this.isActive = isActive;
		this.imageurl = imageurl;
		this.adminUserId = adminUserId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setResturantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", resturantName=" + restaurantName + ", address=" + address
				+ ", rating=" + rating + ", cuisine=" + cuisine + ", deliveryTime=" + deliveryTime + ", isActive="
				+ isActive + ", imageurl=" + imageurl + ", adminUserId=" + adminUserId + "]";
	}
	
	
	
}
